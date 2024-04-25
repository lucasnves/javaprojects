package br.ufla.gac106.s2022_2.Spotfly;

import java.util.Collection;

import br.ufla.gac106.s2022_2.base.Avaliacao;
import br.ufla.gac106.s2022_2.base.Avaliacoes;

public class AvaliacoesObras implements Avaliacoes{

    private String tema;
    private Collection<Avaliacao> avaliacoes;

    public AvaliacoesObras(String tema,Collection<Avaliacao> avaliacoes ){
        this.tema = tema;
        this.avaliacoes = avaliacoes;
    }


    @Override
    public String temaAvaliacao() {
        return tema;
    }

    @Override
    public Collection<Avaliacao> colecaoAvaliacoes() {
        return avaliacoes;
    }
    
}
