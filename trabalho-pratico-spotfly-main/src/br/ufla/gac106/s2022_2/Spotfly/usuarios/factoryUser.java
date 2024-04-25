package br.ufla.gac106.s2022_2.Spotfly.usuarios;

import java.io.Serializable;

public class factoryUser implements Serializable{
    
    public Usuario createUsuario(TipoUser tipo,String email, String senha){
        Usuario user = null;
        if(tipo==TipoUser.ADMINISTRADOR){
            user = new Administrador(email, email);
        }
        else if(tipo==TipoUser.MODERADOR){
            user = new Moderador(email, email);
        }
        else if(tipo==TipoUser.COMUM){
            user = new Comum(email, email);
        }
        return user;
    }
}
