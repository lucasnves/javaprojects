package br.ufla.gac106.s2022_2.Spotfly;

import java.util.Scanner;

public class Informacoes {
    // Scanner para obter dados do usuário via terminal
    private static Scanner entrada = new Scanner(System.in);

    //Pede informações ao usuário e retorna ao sistema
    public static String getString(String texto){
        try{
            System.out.print(texto);
            String info = entrada.nextLine().trim(); //metodo trim é utilizado para evitar que o usuário envei espaços em branco
            if(info.isEmpty()){
                throw new NullPointerException();//usuario não digitou
            }
            return info;
        }catch(NullPointerException e ){
            System.out.println("*Valor informado inválido \n");
            return getString(texto);
        }
    }

    public static int getInt(String texto) {
        try{
            System.out.print(texto);
            int numero = Integer.parseInt(entrada.nextLine());
            return numero;
        }catch(NumberFormatException e){
            System.out.print("*O valor informado deve ser um número\n");
            return getInt(texto);
        }
        catch(NullPointerException e){
            System.out.print("*O valor informado deve ser um número\n");
            return getInt(texto);
        }
    }
}
