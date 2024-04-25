package filme;

import java.util.HashMap;
import series.SerieDados;

public class DadoSeriesFilme implements SerieDados {
    
    private String nomeFilme;
    private int diaInicial;
    private int diaFinal;
    private HashMap<Integer, Integer> serieDados;

    public DadoSeriesFilme(String nomeFilme, int diaInicial, int diaFinal) {
        this.nomeFilme = nomeFilme;
        this.diaInicial = diaInicial;
        this.diaFinal = diaFinal;
        serieDados = new HashMap<>();
    }

    @Override
    public String obterIdentificacaoSerie() {
        return nomeFilme;
    }

    @Override
    public int obterDiaInicial() {
        return diaInicial;
    }

    @Override
    public int obterDiaFinal() {
        return diaFinal;
    }

    @Override
    public int obterDado(int dia) {
        return serieDados.get(dia);
    }

    public String adicionaDado(int dia, int dado) {
        if(dia >= diaInicial && dia <= diaFinal) {
            serieDados.put(dia, dado);
            return "Adicionado!";
        } else {
            return "Nao foi possivel adicionar!";
        }
    }
    
}

