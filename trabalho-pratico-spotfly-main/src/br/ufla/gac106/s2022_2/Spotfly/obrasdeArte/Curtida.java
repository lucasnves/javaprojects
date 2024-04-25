package br.ufla.gac106.s2022_2.Spotfly.obrasdeArte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufla.gac106.s2022_2.Spotfly.usuarios.Usuario;

public class Curtida implements Serializable {
    private List<Usuario> usuarios;

    public Curtida() {

        usuarios = new ArrayList<>();
    }
//boleano
    public String curtirObra(Usuario usuario) {
        for (Usuario user : usuarios) {
            if (user.getLogin().equals(usuario.getLogin())) {
                return "\nVocê já curtiu essa publicação!";
            }
        }
        usuario.curtir(); //soma uma curtida no total de curitdas do usuário
        usuarios.add(usuario);
        return "\nObra curtida com sucesso!";
    }

    public String descurtir(Usuario usuario) {

        for (Usuario user : usuarios) {
            if (user.getLogin().equals(usuario.getLogin())) {
                usuarios.remove(user);
                usuario.descurtir(); //retira uma curtida no total de curitdas do usuário
                return "\nVocê descurtiu essa obra de arte.";
            }
        }
        return "\nVocê ainda não curtiu essa obra para descurti-la";
    }

    public int getCurtidas() {
        return usuarios.size();
    }
}
