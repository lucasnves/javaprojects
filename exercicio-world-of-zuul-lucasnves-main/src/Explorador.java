import java.util.ArrayList;

public class Explorador {
    private String nome;
    private ArrayList<String> mochila;

    public Explorador(String nome) {
        this.nome = nome;
        mochila = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    
    public void addItem(String item) {
        mochila.add(item);
    }

    public void removeItem(String item) {
        for(int i=0; i < mochila.size(); i++) {
            if(mochila.get(i).equals(item)) {
                mochila.remove(i);
            }
        }
    }

    public String itensMochila() {
        String todosItens = "";
        for(String itm : mochila) {
            todosItens += "'" + itm + "' ";
        }
        return todosItens;
    }
}
