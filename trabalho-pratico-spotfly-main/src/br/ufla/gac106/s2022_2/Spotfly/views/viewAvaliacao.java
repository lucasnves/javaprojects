package br.ufla.gac106.s2022_2.Spotfly.views;

import java.util.List;


import br.ufla.gac106.s2022_2.Spotfly.Informacoes;
import br.ufla.gac106.s2022_2.Spotfly.modulos.AvaliacaoSistema;

public class viewAvaliacao extends View {
    // ATRIBUTOS
    private AvaliacaoSistema avaliacao;

    // METODOS
    public viewAvaliacao() {
       avaliacao = new AvaliacaoSistema();
        executar();
    }

    @Override
    protected int menu() {

        System.out.println("\n-- MENU AVALIACAO --");
        System.out.println(" 1. Listar");
        System.out.println(" 2. Filtrar");
        System.out.println(" 3. Comentar");
        System.out.println(" 4. Classificar (curtir/descutir)");
        System.out.println(" 5. Buscar Item");
        System.out.println(" 6. Sair");
        // int op = Integer.parseInt(entrada.nextLine());
        return Informacoes.getInt("\nDigite a opcao desejada: ");
    }

    @Override
    protected void executar() {
        Avaliar();
    }

    private void Avaliar() {
        int op = 0;
        while (op != 6) {
            op = menu();

            switch (op) {
                case 1: // Listar
                    listar();
                    break;
                case 2: // Filtrar
                    filtro();
                    break;
                case 3: // Comentar
                    comentar();
                    break;
                case 4: // Classificar
                    classificar();
                    break;
                case 5: // Buscar
                    buscarObra();
                    break;
                case 6:
                    avaliacao.encerrar();
                    break;
                default:
                    System.out.print("Opcao invalida!");
                    break;
            }
        }
    }

    private int menuListar() {
        System.out.println("\n-- LISTAR OBRAS --");
        System.out.println(" 1. Por ordem de Nomes");
        System.out.println(" 2. Por ordem de Curtidas");
        // int op = Integer.parseInt(entrada.nextLine());
        return Informacoes.getInt("\nDigite a opcao desejada: ");
    }

    private void listar() {
        int op = menuListar();
        switch (op) {
            case 1:// ordenar por nome
                System.out.println(avaliacao.listarObras(1));
                break;
            case 2:// ordena por curtida
                System.out.println(avaliacao.listarObras(2));
                break;
            default:
                System.out.println("\n*Opção invalida");
                break;
        }
    }

    // Ver lista de itens cadastrados e classificacoes médias
    // Filtrar intes cadastrados (nomes , itens sem classificacao, todos)
    // Comentar item (autor, comentario persistir, inserir varios comentarios)
    private void comentar() {
        String nomeObra = Informacoes.getString("Digite o nome da obra: ");
        String comentario = Informacoes.getString("Comentario: ");
        System.out.println(avaliacao.comentar(nomeObra, comentario));
    }

    private int menuClassificar() {
        System.out.println("\n-- CLASSIFICAR OBRA --");
        System.out.println(" 1. Curtir");
        System.out.println(" 2. Descurtir");
        // int op = Integer.parseInt(entrada.nextLine());
        return Informacoes.getInt("\nDigite a opcao desejada: ");
    }

    private void classificar() {
        int op = menuClassificar();
        switch (op) {
            case 1:// curtir obra
                curtirObra();
                break;
            case 2:// descutir obra
                descutirObra();
                break;
            default:
                System.out.println("\n*Opção invalida");
                break;
        }
    }

    private void curtirObra() {
        String nomeObra = Informacoes.getString("Digite o nome da obra: ");
        System.out.println(avaliacao.curtirObra(nomeObra));
    }

    private void descutirObra() {
        String nomeObra = Informacoes.getString("Digite o nome da obra: ");
        System.out.println(avaliacao.descurtir(nomeObra));
    }

    private void buscarObra() {
        String nomeObra = Informacoes.getString("Digite o nome da obra: ");
        System.out.println(avaliacao.buscarObra(nomeObra));
    }

    private int menuFiltro() {
        System.out.println("\n-- FILTRAR OBRAS --");
        System.out.println(" 1. Por obras com a palavra: ");
        System.out.println(" 2. Obras sem classificao: ");
        System.out.println(" 3. Cancelar ");
        // int op = Integer.parseInt(entrada.nextLine());
        return Informacoes.getInt("\nDigite a opcao desejada: ");
    }

    private void filtro(){
        int op = menuFiltro();
        switch (op) {
            case 1:// buscar obra que contem
                filtrarNome();
                break;
            case 2:// obras sem curtida
                filtrarSemClassificao();
                break;
            case 3:// obras sem curtida
                break;    
            default:
                System.out.println("\n*Opção invalida");
                break;
        }

    }

    private void filtrarNome(){
        String buscar = Informacoes.getString("Buscar por obras que contem: ");
        String resultado = avaliacao.filtrarNome(buscar);
        System.out.println("Filtrando por obras que contem: "+"\n"+resultado);
    }

    private void filtrarSemClassificao(){
        System.out.print("\n*Filtrando por obras sem classifição:\n");
        List<String> obrasSemClassificao = avaliacao.intensSemClassificao();
        for(String NomeObra :obrasSemClassificao ){
            System.out.print("- " +NomeObra+"\n");
        }
    }

    //padarao de projetos.
}
