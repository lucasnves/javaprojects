package br.ufla.gac106.s2022_2.Spotfly.usuarios;

public class Administrador extends Usuario {
    public Administrador(String login, String senha) {
        super(login, senha, TipoUser.ADMINISTRADOR);
    }
}
