package br.ufla.gac106.s2022_2.Spotfly;

import br.ufla.gac106.s2022_2.Spotfly.obrasdeArte.ObradeArte;
import br.ufla.gac106.s2022_2.base.Avaliacao;

public class AvaliacaoObra implements Avaliacao {

    private ObradeArte obra;

    public AvaliacaoObra(ObradeArte obra){
        this.obra = obra;
    }

    @Override
    public String nomeItemAvaliado() {
        return obra.getNome();
    }

    @Override
    public double classificacaoMedia() {
        return obra.getQntCurtidas();
    }
    
}
