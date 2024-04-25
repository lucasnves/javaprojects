public class Animal {
    private String nome;
    private String especie;
    private int qntPatas;
    private String som;

    public Animal(String nome, String especie, int qntPatas, String som) {
        this.nome = nome;
        this.especie = especie;
        this.qntPatas = qntPatas;
        this.som = som;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public int getQntPatas() {
        return qntPatas;
    }

    public String getSom() {
        return som;
    }

    public String descricao() {
        return nome + " e um " + especie;
    }

    public String descricaoLonga() {
        return descricao() + " que faz " + som;
    }
}
