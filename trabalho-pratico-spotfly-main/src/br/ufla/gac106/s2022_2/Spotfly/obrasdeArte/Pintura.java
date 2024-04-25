package br.ufla.gac106.s2022_2.Spotfly.obrasdeArte;

public class Pintura extends ObradeArte {

    // Atributos
    private String preco;
    private String categoria;

    // Métodos
    public Pintura(String nome, String autor, String descricao, String preco, String categoria) {
        super(nome, autor, TipoObra.PINTURA, descricao);
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String getDescricaoCompleta() {
        String descricao = super.getDescricaoCompleta() + "Preco: " + preco + "\nCategoria: " + categoria + "\n";
        return descricao;
    }
}
