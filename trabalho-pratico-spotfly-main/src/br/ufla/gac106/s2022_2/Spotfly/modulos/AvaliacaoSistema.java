package br.ufla.gac106.s2022_2.Spotfly.modulos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.ufla.gac106.s2022_2.Spotfly.obrasdeArte.Comentario;
import br.ufla.gac106.s2022_2.Spotfly.obrasdeArte.Curtida;
import br.ufla.gac106.s2022_2.Spotfly.obrasdeArte.ObradeArte;
import br.ufla.gac106.s2022_2.Spotfly.usuarios.Usuario;

public class AvaliacaoSistema {

    // Atributos
    private Usuario usuarioLogado;
    private List<ObradeArte> obras;// indica toda as obras cadastradas no sitema

    public AvaliacaoSistema() {
        obras = Administracao.getInstancia().getListObras();
        usuarioLogado = Administracao.getInstancia().getUserLogado();
    }

    public void encerrar() {
        Administracao.getInstancia().encerrar();
    }

    public String comentar(String nomeObra, String NovoComentario) {

        // Pesquisa obra
        for (ObradeArte obra : obras) {

            if (obra.getNome().equals(nomeObra)) { // encontrou obra
                List<Comentario> comentarios = obra.getComentarios(); // obtem comentarios da obra
                for (Comentario comentario : comentarios) { // busca pelo usuario
                    if (comentario.getUser().getLogin().equals(usuarioLogado.getLogin())) { // usuario já comentou
                        comentario.comentar(NovoComentario); // adiciona mais um novo comentario
                        return "Comentario realizado! Você já comentou mais de uma vez.";
                    }
                }
                // Usuario nunca comentou
                Comentario c = new Comentario();
                c.novoComentario(usuarioLogado, NovoComentario);
                obra.addComentario(c);
                return "Comentario realizado!";
            }
        }
        return "Não foi possível encontrar sua obra";
    }

    private class NomeComparator implements Comparator<ObradeArte> {
        @Override
        public int compare(ObradeArte obraUm, ObradeArte obraDois) {
            String obra1 = obraUm.getNome().toUpperCase();
            String obra2 = obraDois.getNome().toUpperCase();
            return obra1.compareTo(obra2);
        }
    }

    private class CurtidaComparator implements Comparator<ObradeArte> {
        @Override
        public int compare(ObradeArte obraUm, ObradeArte obraDois) {
            return Integer.compare(obraDois.getQntCurtidas(), obraUm.getQntCurtidas());
        }
    }

    public List<ObradeArte> obrasOrdenados() {
        obras.sort(new CurtidaComparator());
        return obras;
    }

    public String listarObras(int opcao) {
        if (opcao == 1) {
            obras.sort(new NomeComparator());
        } else if (opcao == 2) {
            obras.sort(new CurtidaComparator());
        }

        String todasObras = "";
        if (!obras.isEmpty()) {
            todasObras = "\nListagem de Obras cadastradas:\n";
            for (ObradeArte obra : obras) {
                todasObras += "- " + obra.getNome() + " | Curtidas: " + obra.getQntCurtidas() + "\n";
            }
        } else {
            todasObras = "\nNenhuma Obra cadastrada.";
        }
        return todasObras;
    }

    public String curtirObra(String nomeObra) {
        ObradeArte obra = getObra(nomeObra);
        if (obra != null) {
            try {
                Curtida curtir = obra.getCurtida();
                return curtir.curtirObra(usuarioLogado);
            } catch (NullPointerException e) {
                Curtida novaCurtida = new Curtida();
                novaCurtida.curtirObra(usuarioLogado);
                obra.curtir(novaCurtida);
                return "\nObra curtida com sucesso!";
            }
        }
        return "\nObra não cadastrada";
    }

    public int getTotalCurtidas(String nomeObra) {
        ObradeArte obra = getObra(nomeObra);
        if (obra != null) {
            return obra.getQntCurtidas();
        }
        return 0;
    }

    private ObradeArte getObra(String nomeObra) {
        for (ObradeArte obra : obras) {
            if (obra.getNome().equals(nomeObra)) {
                return obra;
            }
        }
        return null;
    }

    public String descurtir(String nomeObra) {
        ObradeArte obra = getObra(nomeObra);
        if (obra != null) {
            Curtida curtir = obra.getCurtida();
            return curtir.descurtir(usuarioLogado);
        }
        return "\nObra não cadastrada";
    }

    public String buscarObra(String nomeObra) {
        String info = "";
        ObradeArte obra = getObra(nomeObra);
        if (obra != null) {
            info = obra.getDescricaoCompleta() + "\n\tTotal de curtidas: " + obra.getQntCurtidas() + "\n"
                    + obra.obterTodosOsComentarios();
            return info;
        }
        return "\nObra não cadastrada";
    }

    // verifica se uma palavra é subgrupo de outra
    public String filtrarNome(String nomeObra) {
        String filtro = "";
        for (ObradeArte obra : obras) {
            if (obra.getNome().toLowerCase().contains(nomeObra.toLowerCase())) {
                filtro += "- " + obra.getNome() + "\n";
            }
        }
        return filtro;
    }

    public List<String> intensSemClassificao() {
        List<String> obrasSemClassificao = new ArrayList<>();

        for (ObradeArte o : obras) {
            if (o.getQntCurtidas() == 0) {
                obrasSemClassificao.add(o.getNome());
            }
        }
        return obrasSemClassificao;
    }

    public List<String> intensClassificados() {
        List<String> obrasSemClassificao = new ArrayList<>();
        obras.sort(new CurtidaComparator());

        for (ObradeArte o : obras) {
            if (o.getQntCurtidas() > 0) {
                obrasSemClassificao.add(o.getNome());
            }
        }
        return obrasSemClassificao;
    }

}
