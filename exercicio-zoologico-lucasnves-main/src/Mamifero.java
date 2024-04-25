public class Mamifero extends Animal {
    private String corPelo;

    public Mamifero(String nome, String especie, int qntPatas, String som, String corPelo) {
        super(nome, especie, qntPatas, som);
        this.corPelo = corPelo;
    }

    public String getCorPelo() {
        return corPelo;
    }

    @Override
    //alterando para sobrescrever a descrição
    public String descricaoLonga() {
        return super.descricaoLonga() + " e tem pelo " + corPelo;
    }
}
