package br.ufla.gac106.s2022_2.Spotfly.usuarios;

import java.io.Serializable;

public abstract class Usuario implements Serializable{

    //Atributos
    private String login;
    private String senha;
    private TipoUser tipo; 
    private int qtdCurtidas;
    private int qtdComentarios;

    //Métodos
    public Usuario(String login, String senha, TipoUser tipo){
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        qtdCurtidas = 0;
        qtdComentarios = 0;
    }
    public TipoUser getTipo(){
        return tipo;
    }
    public String getLogin(){
        return login;
    }
    public String getSenha(){
        return senha;
    }

    public void curtir(){
        qtdCurtidas++;
    }

    public void descurtir(){
        qtdCurtidas--;
    }

    public void IncrementaComentar(){
        qtdComentarios++;
    }

    public int getQuantidadeCurtidas(){
        return qtdCurtidas;
    }

    public int getQuantidadeComentarios(){
        return qtdComentarios;
    }
}
