package br.ufla.gac106.s2022_2.Spotfly.views;

import br.ufla.gac106.s2022_2.Spotfly.ControleAcesso;
import br.ufla.gac106.s2022_2.Spotfly.Informacoes;
import br.ufla.gac106.s2022_2.Spotfly.modulos.EnumModulo;

public abstract class View {

    public View() {
        if(!ControleAcesso.getInstancia().usuarioJaLogado()){
            login();
        }
    }

    protected abstract int menu();

    protected abstract void executar();

    private boolean verificaAcesso(EnumModulo modulo) {
        return ControleAcesso.getInstancia().VerificaAcesso(modulo);
    }

    // verifica se o usuario possui acesso ao modulo
    protected boolean getAcesso(EnumModulo modulo) {
        if (!verificaAcesso(modulo)) {
            System.out.println("\n*Voce não possui acesso");
            return false;
        }
        return true;
    }//

    // Mensagem exibidia quando inicia o sistema
    private void mensagemBoasVindas() {
        System.out.println("- - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("|\t  Bem vindo a plataforma Spotfly - desde 1987 dando asas a sua imaginação!\t|");
        System.out
                .println("- - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        System.out.println("Para continuar, faça login no Spotfly:");
    }

    /*
     * interface de login exibida quando 
     * o usuário ainda não fez login no sistema.
     */
    private void login() {
        mensagemBoasVindas();
        boolean loginRealizado = false;
        do {
            String email = Informacoes.getString("Email do usuario: ");
            String senha = Informacoes.getString("Senha do usuario: ");
            loginRealizado =  ControleAcesso.getInstancia().login(email, senha);
            if (!loginRealizado) {
                System.out.println("*Email ou Senha incorreta\n");
            }
        } while (!loginRealizado);
    }

}
