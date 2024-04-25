/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.ChevroletFabrica;
import fabricaautomoveis.carros.FabricaCarro;
import fabricaautomoveis.carros.FiatFabrica;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.VWFabrica;

import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;

    public void exibir() {

        ppooVeiculos = new Concessionaria("PPOO Veículos");
        entrada = new Scanner(System.in);
        escolherFranquia();
        int opcao;
        do {
            opcao = menu();

            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    escolherFranquia();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 3);
    }

    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Trocar Franquia");
        System.out.println("3 - Sair");

        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());

        System.out.print("Escolha a categoria (1: Popular, 2: Pickup ou 3: Luxo): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));

        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();

        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");
        } else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }

        esperarTecla();
    }

    private void escolherFranquia() {
        System.out.println("Escolha a franquia (1: FIAT, 2: VW, 3: CHEVROLET): ");
        FabricaCarro fabrica;
        int tipo = Integer.parseInt(entrada.nextLine());
        switch (tipo) {
            case 1:
                fabrica = new FiatFabrica();
                ppooVeiculos.trocarFranquia(Marca.FIAT, fabrica);
                break;
            case 2:
                fabrica = new VWFabrica();
                ppooVeiculos.trocarFranquia(Marca.VW, fabrica);
                break;
            case 3:
                fabrica = new ChevroletFabrica();
                ppooVeiculos.trocarFranquia(Marca.CHEVROLET, fabrica);
                break;
        }
    }

    private void esperarTecla() {
        entrada.nextLine();
    }
}
