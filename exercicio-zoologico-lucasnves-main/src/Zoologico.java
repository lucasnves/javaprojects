import java.util.ArrayList;

public class Zoologico {
    private ArrayList<Animal> animais;

    public Zoologico() {
        animais = new ArrayList<>();
    }

    public void cadastrarLeao(String nome, String corPelo) {
        animais.add(new Leao(nome, corPelo));
    }

    public void cadastrarGorila(String nome, String corPelo) {
        animais.add(new Gorila(nome, corPelo));
    }

    public void cadastrarEma(String nome, String voo) {
        animais.add(new Ema(nome, voo));
    }

    public void cadastrarArara(String nome, String voo) {
        animais.add(new Arara(nome, voo));
    }

    public String descCompletaNome(String nome) {

        for(Animal a : animais) {
            if(a != null && a.getNome().equals(nome)) {
                return a.descricaoLonga();
            }
        }
        return "Nao existe nenhum animal com esse nome";
    }

    public String listaAnimais() {
        String descricao = "";

        for(Animal a : animais) {
            descricao += a.descricao() + "\n";
        }
        if (descricao == "") {
            return "Nao existe animais cadastrados.";
        }
        return descricao;
    }

    public String listaAnimaisCompleto() {
        String descricao = "";

        for(Animal a : animais) {
            descricao += a.descricaoLonga() + "\n";
        }
        if (descricao == "") {
            return "Nao existe animais cadastrados.";
        }
        return descricao;
    }
}
