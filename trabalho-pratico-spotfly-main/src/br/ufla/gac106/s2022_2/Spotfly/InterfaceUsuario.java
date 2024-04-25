package br.ufla.gac106.s2022_2.Spotfly;

import br.ufla.gac106.s2022_2.Spotfly.modulos.EnumModulo;
import br.ufla.gac106.s2022_2.Spotfly.views.EnumView;
import br.ufla.gac106.s2022_2.Spotfly.views.View;
import br.ufla.gac106.s2022_2.Spotfly.views.FactoryView;

public class InterfaceUsuario extends View{

    private FactoryView factory;

    public InterfaceUsuario() {
        factory = new FactoryView();
        executar();
    }

    // inicia o sistema

    @Override
    public void executar() {
        menuGeral();
    }

    @Override
    protected int menu() {
        System.out.println("\n-- MENU GERAL --");
        System.out.println(" 1. Modulo Administracao");
        System.out.println(" 2. Modulo Avaliação");
        System.out.println(" 3. Modulo Relatorios");
        System.out.println(" 4. Encerrar Sistema");
        return Informacoes.getInt("\nDigite a opcao desejada: ");
    }

    // Menu inicial
    private void menuGeral() {
        

        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:// Administracao
                    if(getAcesso(EnumModulo.ADMINISTRACAO)){
                        factory.criarView(EnumView.VIEWADMINISTRACAO);
                    }
                    break;
                case 2:// Avaliacao
                    if(getAcesso(EnumModulo.AVALIACAO)){
                        factory.criarView(EnumView.VIEWAVALIACAO);
                    }
                    break;
                case 3:// Relatorio
                    if(getAcesso(EnumModulo.RELATORIO)){
                        factory.criarView(EnumView.VIEWRELATORIO);
                    }
                    break;
                case 4:
                    System.out.println("*Você está saindo do sistema!");
                    break;
                default:
                    System.out.println("\n*Opção invalida!");
                    break;
            }
        } while (opcao != 4);
    }
}
