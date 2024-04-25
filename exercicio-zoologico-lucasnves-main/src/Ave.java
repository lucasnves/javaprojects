public class Ave extends Animal {
    private String voo;

    public Ave(String nome, String especie, int qntPatas, String som, String situVoo) {
        super(nome, especie, qntPatas, som);
        this.voo = situVoo;
    }

    public String getVoo() {
        return voo;
    }

    @Override
    //alterando para sobrescrever a descrição
    public String descricaoLonga() {
        return super.descricaoLonga() + " e voa " + voo;
    }
}
