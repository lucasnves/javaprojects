/*
 * Classe responsável por salvar um arquivo binário com os dados cadastrados no sistema
 * ele recebe um objeto do tipo Administracao como parametro para salvar e devolve 
 * o mesmo tipo de objeto quando carrega os dados para o sistema.  
 * 
 */

package br.ufla.gac106.s2022_2.Spotfly;

//import necessarios para trabalhar com arquivos binários
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.ufla.gac106.s2022_2.Spotfly.modulos.Administracao;

public  class Arquivo {

	private String nomeArquivo = "dados.bin";

	// salvar os dados no arquivo binário - - - - - - - - - - - - - - -
	public void salvarDados(Administracao administracao) {
		try {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo));

			oos.writeObject(administracao);
			oos.close();
		} catch (IOException e) {
			// trate o erro aqui
			e.printStackTrace();
			System.out.println("Erro");
		}

	}

	// Busca pelo arquivo binário e obtem os dados cadastrados - - - - - -
	public Administracao getDados() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo));
			Administracao administracao = (Administracao) ois.readObject();

			ois.close();
			return administracao;
		}catch(NullPointerException e){
			return null;
		}
		
		catch (IOException e) {
			return null;
		} 
		catch (ClassNotFoundException e) {
			return null;
			// e.printStackTrace();
		}
	}
}
