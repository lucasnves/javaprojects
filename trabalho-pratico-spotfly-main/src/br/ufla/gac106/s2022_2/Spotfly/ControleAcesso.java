/*
    Classe responsável por admnistrar o acesso aos modulos do sistema.
    Ela recebe por parametro os modulos que o usuário possui acesso, e o usuario,
    salva em um HashMap no qual o tipo do usuario é usado como chave e armazena 
    em um vetor de Integer todos os modulos passados
 */

package br.ufla.gac106.s2022_2.Spotfly;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.ufla.gac106.s2022_2.Spotfly.modulos.Administracao;
import br.ufla.gac106.s2022_2.Spotfly.modulos.EnumModulo;
import br.ufla.gac106.s2022_2.Spotfly.usuarios.TipoUser;
import br.ufla.gac106.s2022_2.Spotfly.usuarios.Usuario;

public class ControleAcesso implements Serializable {

    // Atributos
    private HashMap<TipoUser, EnumModulo[]> acessos;
    private Usuario usuarioLogado;
    private static ControleAcesso controle;

    /*
     * Padrão de projeto Singleton
     */
    public static ControleAcesso getInstancia() {
        if(controle!=null){ 
            return controle;
        }
        else{
            controle = new ControleAcesso();
            return controle;
        }
    }

    // Métodos
    private ControleAcesso() {
        acessos = new HashMap<>();
        usuarioLogado = null;

        // Define quais sãos os modulos acessíveis para o adminsitrador
        EnumModulo acessosAdm[] = { EnumModulo.ADMINISTRACAO, EnumModulo.AVALIACAO, EnumModulo.RELATORIO,
                EnumModulo.ADM_CADASTRARITEM, EnumModulo.ADM_CADASTRARUSUARIO,
                EnumModulo.ADM_EXCLUIRITEM, EnumModulo.ADM_VISUALIZARITEM,EnumModulo.ADM_CADASTRARADM };
        setAcesso(TipoUser.ADMINISTRADOR, acessosAdm);

        // Define quais sãos os modulos acessíveis para o moderador
        EnumModulo acessosMod[] = { EnumModulo.ADMINISTRACAO, EnumModulo.AVALIACAO, EnumModulo.RELATORIO,
                EnumModulo.ADM_CADASTRARITEM, EnumModulo.ADM_VISUALIZARITEM, EnumModulo.ADM_CADASTRARUSUARIO };
        setAcesso(TipoUser.MODERADOR, acessosMod);

        // Define quais sãos os modulos acessíveis para o usuário comum
        EnumModulo acessosComum[] = { EnumModulo.ADMINISTRACAO, EnumModulo.AVALIACAO,EnumModulo.RELATORIO,
                EnumModulo.ADM_VISUALIZARITEM };
        setAcesso(TipoUser.COMUM, acessosComum);
    }

    // Define para os tipos os modulos que possuem acesso
    private void setAcesso(TipoUser tipo, EnumModulo[] modulos) {
        acessos.put(tipo, modulos);
    }

    // verifica se o usuario possui acesso ao modulo que está sendo solicitado
    public boolean VerificaAcesso(EnumModulo modulo) {
        EnumModulo[] acessosUser = acessos.get(usuarioLogado.getTipo());
        for (int i = 0; i < acessosUser.length; i++) {
            if (modulo.equals(acessosUser[i])) {
                // Possui acesso
                return true;
            }
        }
        // Não possui acesso
        return false;
    }

    public  Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean login(String email, String senha) {

        Map<String, Usuario> usuarios = Administracao.getInstancia().getMapUsuarios();// indica todos os usuários cadastrados no sistema
        Usuario user = usuarios.get(email);
        if (user != null) {
            if (user.getSenha().equals(senha)) {
                usuarioLogado = user;
                return true;
            }
        }
        return false;
    }

    public boolean usuarioJaLogado(){
        if(usuarioLogado!=null){
            return true;
        }
        return false;
    }
}
