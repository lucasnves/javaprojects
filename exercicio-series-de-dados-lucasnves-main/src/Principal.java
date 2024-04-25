import java.util.List;

import filme.controleSeries;
import series.SerieDados;
import series.VisualizadorSeries;

public class Principal {
    public void executar() {
        controleSeries controle = new controleSeries();
        List<SerieDados> lista = controle.getDados();

        for(SerieDados a : lista) {
            System.out.println("Dados da Serie Bilheteria do filme " + a.obterIdentificacaoSerie() + ":");
            for(int i=a.obterDiaInicial(); i <= a.obterDiaFinal(); i++){
                System.out.println("Dia " + i + ": " + a.obterDado(i));
            }
        }

        VisualizadorSeries visualizarDados = new VisualizadorSeries(lista);
        visualizarDados.exibir();
    }
}