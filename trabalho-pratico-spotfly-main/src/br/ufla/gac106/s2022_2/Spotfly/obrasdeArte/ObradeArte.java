package br.ufla.gac106.s2022_2.Spotfly.obrasdeArte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ObradeArte implements Serializable {

    private String nome;
    private String autor;
    private TipoObra tipo;
    private String descricaoWiki;
    
    private List<Comentario> comentarios;
    private Curtida curtida;

    public ObradeArte(String nome, String autor, TipoObra tipo, String descricaoWiki) {
        this.nome = nome;
        this.autor = autor;
        this.tipo = tipo;
        this.descricaoWiki = descricaoWiki;
        comentarios = new ArrayList<>();
        curtida = new Curtida();
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public TipoObra getTipo() {
        return tipo;
    }

    public String getDescricaoWiki() {
        return descricaoWiki;
    }

    public String getDescricaoCompleta() {
        String descricaoCompleta = "\nNome: " + nome + "\n" + "Tipo: " + tipo + "\n" + "Autor: " + autor + "\n"
                + "Descricao: " + descricaoWiki + "\n";
        return descricaoCompleta;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public String obterTodosOsComentarios() {
        String todosComentarios = "";
        if (!comentarios.isEmpty()) {
            todosComentarios = "\tComentarios:";
            for (Comentario c : comentarios) {
                todosComentarios += "\n\t\t'" + c.getAutor() + "' comentou:\n";
                List<String> comentariosUsuario = c.getComentarios();
                for (String umComentario : comentariosUsuario) { // insere todos os comentarios de um unico usuario
                    todosComentarios += "\t\t\t" + umComentario + "\n";
                }
            }
        } else {
            todosComentarios = "\tNao ha comentarios.";
        }

        return todosComentarios;
    }

    public void addComentario(Comentario novoComentario) {
        comentarios.add(novoComentario);
    }

    public void curtir(Curtida curtida) {
        if (this.curtida == null) {
            this.curtida = curtida;
        }
    }

    public Curtida getCurtida() {
        return curtida;
    }

    public int getQntCurtidas() {
        return curtida.getCurtidas();
    }
}
