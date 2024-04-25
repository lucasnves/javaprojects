package br.ufla.gac106.s2022_2.Spotfly.usuarios;

public class Moderador extends Usuario {
    public Moderador(String login, String senha) {
        super(login, senha, TipoUser.MODERADOR);
    }
}
