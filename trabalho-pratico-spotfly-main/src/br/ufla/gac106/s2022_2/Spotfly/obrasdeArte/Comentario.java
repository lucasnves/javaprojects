package br.ufla.gac106.s2022_2.Spotfly.obrasdeArte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.ufla.gac106.s2022_2.Spotfly.usuarios.Usuario;

public class Comentario implements Serializable{
    private Usuario usuario;
    private List<String> comentarios;
    private LocalDateTime horaData;

    public Comentario(){
        comentarios = new ArrayList<>();
    }

    public List<String> getComentarios(){
        return comentarios;
    }

    public void comentar(String novoComentario){
       
        String comentario = novoComentario +getDataHora();
        usuario.IncrementaComentar();//incrementa comentar
        comentarios.add(comentario);
    }

    public void novoComentario(Usuario usuario, String comentario){
        this.usuario = usuario;
        comentar(comentario);
    }
    
    public Usuario getUser(){
        return usuario;
    }

    public String getAutor(){
        return usuario.getLogin();
    }

    private String getDataHora(){
        horaData = LocalDateTime.now();
        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm");

        String dataFormatada = horaData.format(data);
        String horaFormatada = horaData.format(hora);

        return " - data: "+dataFormatada+" horário: "+horaFormatada;
    }

    public int totalComentario(){
        return comentarios.size();
    }
}
