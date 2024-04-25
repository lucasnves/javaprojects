package br.ufla.gac106.s2022_2.Spotfly.views;

import java.util.List;

//importa necessarios da API
import br.ufla.gac106.javaWikiAPI.PaginaWiki;
import br.ufla.gac106.javaWikiAPI.Wiki;
import br.ufla.gac106.s2022_2.Spotfly.Informacoes;
import br.ufla.gac106.s2022_2.Spotfly.modulos.Administracao;
import br.ufla.gac106.s2022_2.Spotfly.modulos.EnumModulo;

public class viewAdmnistracao extends View {

    
    private Wiki wiki;// Variável necessária para o uso da API

    public viewAdmnistracao() {

        wiki = new Wiki();
        executar();
    }

    @Override
    public void executar() {
        Administracao();
    }

    // Menu de administração
    @Override
    protected int menu() {

        System.out.println("\n-- MENU ADMINISTRACAO --");
        System.out.println(" 1. Cadastrar itens");
        System.out.println(" 2. Visualizar itens");
        System.out.println(" 3. Excluir itens");
        System.out.println(" 4. Cadastrar usuarios");
        System.out.println(" 5. Sair de Administração");
        // int op = Integer.parseInt(entrada.nextLine());
        return Informacoes.getInt("\nDigite a opcao desejada: ");
    }

    // - - - *Modulo de Administração* - - -
    private void Administracao() {
        int op = 0;
        while (op != 5) {
            op = menu();

            switch (op) {
                case 1:// cadastrar item
                    if (getAcesso(EnumModulo.ADM_CADASTRARITEM)) {
                        cadastrarItem();
                    }
                    break;
                case 2:// visulizar item
                    if (getAcesso(EnumModulo.ADM_VISUALIZARITEM)) {
                        visualizarItens();
                    }
                    break;
                case 3:// excluir item
                    if (getAcesso(EnumModulo.ADM_EXCLUIRITEM)) {
                        excluirItem();
                    }
                    break;
                case 4:// cadastrar usuario
                    if (getAcesso(EnumModulo.ADM_CADASTRARUSUARIO)) {
                        cadastrarUsuario();
                    }
                    break;
                case 5:// sair do sistema
                   Administracao.getInstancia().encerrar();
                    break;
                default:
                    System.out.print("Opcao invalida!");
                    break;
            }
        }

    }

    // Menu exibido quando o usuário acessa o cadastramento de itens
    private int menuCadastrar() {
        System.out.println("\n-- CADASTRAR ITENS --");

        int opcao;
        do {
            System.out.println("\nOque deseja cadastrar?");
            System.out.println(" 1. Música");
            System.out.println(" 2. Pintura");
            System.out.println(" 3. cancelar");
            opcao = Informacoes.getInt("\nDigite a opcao desejada: ");
        } while (opcao < 0 || opcao > 3);

        return opcao;
    }

    // Cadastrar itens no sistema
    private void cadastrarItem(){  
        int opcao = menuCadastrar();
        if(opcao!=3){

            String autor = Informacoes.getString("Digite o autor: ");
            String nomeI = Informacoes.getString("Digite o nome da obra: ");
            
            if(Administracao.getInstancia().getNomeItem(nomeI)!=null){
                System.out.println("\n*Não possível cadastrar obras que já existem");
                return;
            }
            String obterDescricao = nomeI;
            String descricao = getDescricaoWiki(obterDescricao);

            int resposta;
            do{
                resposta = Informacoes.getInt("\nA descricao obtida foi o que voce realmente esperava?  (1. Sim, 2. Nao) ");
                if(resposta!=1){
                    obterDescricao = Informacoes.getString("Digite o nome para buscar descricao: ");
                    descricao = getDescricaoWiki(obterDescricao);
                }
                
            }while(resposta!=1);
           
            if(descricao!=null){
                //Acoplamento implicito
                switch(opcao){
                    case 1://Música
                        
                        String estilo = Informacoes.getString("\nDigite o estilo da música: "); 
                        String gravadora = Informacoes.getString("Digite o nome do gravadora: ");
                                            
                        Administracao.getInstancia().cadastrarMusica(nomeI, autor, descricao, gravadora, estilo);
                        break;

                    case 2://Pintura
                        String preco = Informacoes.getString("\nDigite o preco da pintura: ");
                        String categoria = Informacoes.getString("Digite a categoria da pintura: ");
                        
                        Administracao.getInstancia().cadastrarPintura(nomeI, autor, descricao, preco, categoria);
                        break;
        
                    default://Digitou número errado
                        break;               
                }
            }
            else{
                System.out.println("\n*Descricao nao encontrada.");
            }
        }
        else{
            System.out.println("\n*Retornando ao menu");
        }
    }

    // Pega a descricao da pagina na wiki (API) - - - - - - - - - - -
    private String getDescricaoWiki(String titulo) {

        PaginaWiki pagina = null;
        try {
            while ((pagina = wiki.consultarPagina(titulo)) == null) {
                System.out.println("\n*Não foi possível encontar o titulo [" + titulo + "]");
                List<String> titulosDePagina = wiki.pesquisarTitulosDePaginas(titulo);

                System.out.println("\nExibindo títulos de página semelhantes encontrados");
                for (String tituloDePagina : titulosDePagina) {
                    System.out.print(tituloDePagina + " - ");
                }
                titulo = Informacoes.getString("\nEscolha um dos titulos ou digite outro: ");
            }
            if(pagina!=null){
                System.out.println(pagina.getResumo());
            }
        } catch (Exception e) {
            return null;
        }

        return pagina.getResumo();
    }

    // Visualiza um item cadastrado
    private void visualizarItens() {
        String itens = Administracao.getInstancia().getItens();
        // verifica se há itens cadastrados no sitema
        if (itens!="") {
            System.out.println(itens);
            int resposta = Informacoes.getInt("Deseja visualizar algum item? (1. Sim , 2. Nao)\nSua resposta: ");
            // verifica se o usuário quer visualizar um item especifico
            if (resposta == 1) {
                String nome = Informacoes.getString("Digite o nome da obra que deseja visualizar: ");
                System.out.print(Administracao.getInstancia().getDescricaoItem(nome));
            }
        } else {// não há nenhum item cadastrado no sistema
            System.out.println("\n*Nenhuma obra cadastrada ainda.");
        }
    }

    // Excluir item cadastrado
    private void excluirItem() {
        String nomeObra = Informacoes.getString("Digite o nome da obra que deseja excluir: ");
        System.out.println(Administracao.getInstancia().ExcluirItem(nomeObra));
    }

    // cadastrar um usuário no sitema
    private void cadastrarUsuario() {
        // verifica se o usuário já esta cadastrado no sistema
        String email = Informacoes.getString("Digite o email do usuario: ");
        if (Administracao.getInstancia().buscarUser(email)) { //verifica se o usuário já está cadastrado no sistema
            System.out.println("\n*Usuário já cadastrado no sistema!");
            return;
        }
        String senha = Informacoes.getString("Digite a senha do usuario: ");

        // usuário não está cadastrado, entçao disponibliza o cadastro
        System.out.println("\nQual a classificao do usuario?");
        System.out.println(" 1. Administrador");
        System.out.println(" 2. Moderador");
        System.out.println(" 3. Comum");

        int opcao = Informacoes.getInt("\nDigite a opcao desejada: ");
        boolean criado = false;
        switch (opcao) {
            case 1:// administrador
                if(getAcesso(EnumModulo.ADM_CADASTRARADM)){
                    Administracao.getInstancia().cadastrarAdministrador(email, senha);
                    criado = true;
                }else{
                    System.out.println("Você não tem permissão para cadastrar Administradores");
                }
                break;
            case 2:// moderador
                Administracao.getInstancia().cadastrarModerador(email, senha);
                criado = true;
                break;
            case 3:// usuário comum
                Administracao.getInstancia().cadastrarComum(email, senha);
                criado = true;
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }

        System.out.println(criado ? "\n*Cadastrado com sucesso." : "\n*Nao foi possivel cadastrado usuario");

    }

}
