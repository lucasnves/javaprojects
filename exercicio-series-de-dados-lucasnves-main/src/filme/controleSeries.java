package filme;

import java.util.ArrayList;
import java.util.List;

import series.SerieDados;

public class controleSeries {

    private List<SerieDados> dados;
    private DadoSeriesFilme Avatar2;
    private DadoSeriesFilme Titanic;

    public controleSeries() {

        dados = new ArrayList<>();

        Avatar2 = new DadoSeriesFilme("Avatar2", 1, 4);
        Titanic = new DadoSeriesFilme("Titanic", 1, 4);

        Avatar2.adicionaDado(1, 4232672);
        Avatar2.adicionaDado(2, 3367843);
        Avatar2.adicionaDado(3, 7633429);
        Avatar2.adicionaDado(4, 6545899);

        Titanic.adicionaDado(1, 143254);
        Titanic.adicionaDado(2, 3352492);
        Titanic.adicionaDado(3, 6320201);
        Titanic.adicionaDado(4, 9857381);

        dados.add(Avatar2);
        dados.add(Titanic);
    }

    public List<SerieDados> getDados() {
        return dados;
    }
}
