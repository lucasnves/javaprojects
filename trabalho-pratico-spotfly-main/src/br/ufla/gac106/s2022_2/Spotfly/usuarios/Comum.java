package br.ufla.gac106.s2022_2.Spotfly.usuarios;

public class Comum extends Usuario {
    public Comum(String login, String senha) {
        super(login, senha, TipoUser.COMUM);
    }

}
