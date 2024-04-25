package br.ufla.gac106.s2022_2.Spotfly.obrasdeArte;

public class Musica extends ObradeArte {

    // Atributos
    private String gravadora;
    private String estilo;

    // Métodos
    public Musica(String nome, String autor, String descricao, String gravadora, String estilo) {
        super(nome, autor, TipoObra.MUSICA, descricao);
        this.gravadora = gravadora;
        this.estilo = estilo;
    }

    public String getEstilo() {
        return estilo;
    }

    public String getGravadora() {
        return gravadora;
    }

    @Override
    public String getDescricaoCompleta() {
        String descricao = super.getDescricaoCompleta() + "Gravadora: " + gravadora + "\nEstilo: " + estilo + "\n";
        return descricao;
    }
}
