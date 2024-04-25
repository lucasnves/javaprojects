package br.ufla.gac106.s2022_2.Spotfly.views;

import br.ufla.gac106.s2022_2.Spotfly.Informacoes;
import br.ufla.gac106.s2022_2.Spotfly.modulos.Relatorio;

public class viewRelatorio extends View {

    private Relatorio relatorio;

    public viewRelatorio(){
        relatorio = new Relatorio();
        executar();
    }
    
    @Override
    protected int menu(){
        System.out.println("\n-- MENU RELATORIO --");
        System.out.println(" 1. Quantidade de itens classificados");
        System.out.println(" 2. Quantidade de sem classificao");
        System.out.println(" 3. Exibir os 5 melhores classificados");
        System.out.println(" 4. Exibir os 3 usuarios que mais curtiram obras");
        System.out.println(" 5. Exibir os 3 usuarios que mais comentaram");
        System.out.println(" 6. Exibir gráfico");
        System.out.println(" 7. Sair de Relatório");
        // int op = Integer.parseInt(entrada.nextLine());
        return Informacoes.getInt("\nDigite a opcao desejada: ");
    }

    @Override
    protected void executar(){
        Relatorio();
    }

    private void Relatorio() {
        int op = 0;
        while (op != 7) {
            op = menu();

            switch (op) {
                case 1: // qtdItens classificados
                    itensClassificados();
                    break;
                case 2: // qtdItens não classificados
                    intesSemCLassificao();
                    break;
                case 3: // 5 melhores classificados
                    topClassificaoObras();
                    break;
                case 4: // 3 usuarios que mais curtiram
                    topUsersCurtidas();
                    break;   
                case 5: // 3 usuarios que mais comentaram
                    topUsersComentarios();
                    break;
                case 6: // exibir gŕafico
                    getGrafico();
                    break; 
                case 7:
                    break;
                default:
                    System.out.print("Opcao invalida!");
                    break;
            }
        }
    }

    //itens com masi curtidas
    private void topClassificaoObras(){
        
        String topObras = relatorio.melhoresObras(5);
        if(topObras==""){
            System.out.print("\nExibindo melhores obras:\n");
            System.out.print("\n*Não há obras classificadas\n");
        }
        else{
            System.out.print(topObras);
        }
    }
    
    //usuarios que mais comentaram
    private void topUsersComentarios(){
        System.out.print("\nExibindo usuarios que mais comentaram:\n");
        System.out.print(relatorio.usuariosMaisComentaram(3));
    }

    //usuarios que mais curtiram
    private void topUsersCurtidas(){
        System.out.print("\nExibindo usuarios que mais curtiram obras:\n");
        System.out.print(relatorio.usuariosMaisCurtiram(3));
    }

    //retorna usuario
    private void getGrafico(){
        System.out.print("Exibindo gráfico...");
        relatorio.exibirGrafico();
    }

    private void itensClassificados(){
        System.out.print("\nTotal de intens classificados: "+relatorio.getQnt_classificados()+"\n");
    }

    private void intesSemCLassificao(){
        System.out.println("\nTotal de itens sem classificao: "+relatorio.getQnt_naoClassificados());
    }

}
