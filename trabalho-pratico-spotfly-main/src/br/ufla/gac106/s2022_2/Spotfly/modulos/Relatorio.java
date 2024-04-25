package br.ufla.gac106.s2022_2.Spotfly.modulos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import br.ufla.gac106.s2022_2.Spotfly.AvaliacaoObra;
import br.ufla.gac106.s2022_2.Spotfly.AvaliacoesObras;
import br.ufla.gac106.s2022_2.Spotfly.obrasdeArte.ObradeArte;
import br.ufla.gac106.s2022_2.Spotfly.usuarios.Usuario;
import br.ufla.gac106.s2022_2.base.Avaliacao;
import br.ufla.gac106.s2022_2.base.relatorios.Grafico;


/*
 * O módulo de Relatórios seria utilizado para extrair 
 * informações gerais e resumidas do sistema de avaliação.
 */
public class Relatorio {

    private Grafico grafico;
    private AvaliacaoSistema avaliacaoSistema;
    private AvaliacoesObras avaliacoes;
    private List<ObradeArte> obras;


    public Relatorio() {
        avaliacaoSistema = new AvaliacaoSistema();
        grafico = new Grafico();
        obras =  Administracao.getInstancia().getListObras();
        avaliacoes = new AvaliacoesObras("Obras de artes",getColecaoAvaliacoes());
        
    }

    // Retorna a quantidade de itens classificados
    public int getQnt_classificados() {
        List<String> obrasClassificadas = avaliacaoSistema.intensClassificados();
        return obrasClassificadas.size();
    }

    // Retorna a quantidade de itens não classificados.
    public int getQnt_naoClassificados() {
        List<String> obrasSemClassificao = avaliacaoSistema.intensSemClassificao();
        return obrasSemClassificao.size();
     }

    // Quais são os 5 itens melhor classificados, de cada tipo.
    public String  melhoresObras(int num) {
        List<String> obrasClassificadas = avaliacaoSistema.intensClassificados();
        String info = "";
        for(int i = 0 ; i < num; i++){
            try{
                info += " "+(i+1)+"º "+ obrasClassificadas.get(i)+" | curtidas: "+avaliacaoSistema.getTotalCurtidas(obrasClassificadas.get(i))+"\n";
            }
            catch (IndexOutOfBoundsException e){
                return info;
            }
        }

        return info;
    }
     
    // Quem são os 3 usuários que mais classificaram itens.
    public String usuariosMaisCurtiram(int num) {
        Collection<Usuario> colecaoUsuarios = Administracao.getInstancia().getMapUsuarios().values();
        ArrayList<Usuario> arrayUsuarios = new ArrayList<>(colecaoUsuarios);

        arrayUsuarios.sort(new CurtidaComparator());

        String info = "";

        for(int i = 0; i<num; i++){
            try{
               info += " "+(i+1)+"º "+ arrayUsuarios.get(i).getLogin()+ "| curtidas: " + arrayUsuarios.get(i).getQuantidadeCurtidas()+"\n";
            }
            catch (IndexOutOfBoundsException e){
                return info;
            }
        }

        return info;
    }


    // Quem são os 3 usuários que mais classificaram itens.
    public String usuariosMaisComentaram(int num) {
        Collection<Usuario> colecaoUsuarios = Administracao.getInstancia().getMapUsuarios().values();
        ArrayList<Usuario> arrayUsuarios = new ArrayList<>(colecaoUsuarios);

        arrayUsuarios.sort(new ComentarioComparator());

        String info = "";

        for(int i = 0; i<num; i++){
            try{
               info += " "+(i+1)+"º "+ arrayUsuarios.get(i).getLogin()+ "| quantidade de comentarios: " + arrayUsuarios.get(i).getQuantidadeComentarios()+"\n";
            }
            catch (IndexOutOfBoundsException e){
                return info;
            }
        }
        return info;
    }


    public void exibirGrafico(){
        grafico.exibir(avaliacoes.temaAvaliacao(), avaliacoes);
    }

    
    public Collection<Avaliacao> getColecaoAvaliacoes() {
        ArrayList<Avaliacao> listaAvaliacao = new ArrayList<>();
        
        for(ObradeArte obra : obras){
            Avaliacao avaliacao = new AvaliacaoObra(obra);
            listaAvaliacao.add(avaliacao);
        }
        return listaAvaliacao;
    }

    private class CurtidaComparator implements Comparator<Usuario> {
        @Override
        public int compare(Usuario userDois, Usuario userUm) {
            return Integer.compare(userUm.getQuantidadeCurtidas(), userDois.getQuantidadeCurtidas());
        }
    }

    private class ComentarioComparator implements Comparator<Usuario> {
        @Override
        public int compare(Usuario userDois, Usuario userUm) {
            return Integer.compare(userUm.getQuantidadeComentarios(), userDois.getQuantidadeComentarios());
        }
    }
}
