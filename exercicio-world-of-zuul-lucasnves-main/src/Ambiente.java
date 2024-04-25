/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */
import java.util.HashMap;

public class Ambiente  {
    // descrição do ambiente
    private String descricao;
    // ambientes vizinhos de acordo com a direção
    private HashMap<String, Ambiente> saidas;
    private Item item;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas. 
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao)  {
        this(descricao, null, null);
        //this.descricao = descricao;
        //saidas = new HashMap<String, Ambiente>();
    }

    public Ambiente(String descricao, String item, String descItem) {
        this.descricao = descricao;
        saidas = new HashMap<String, Ambiente>();
        if(item != null) {
            this.item = new Item(item, descItem);
        }
    }

    /**
     * Define as saídas do ambiente. Cada direção ou leva a um outro ambiente ou é null 
     * (indicando que não tem nenhuma saída para lá).
     * @param norte A saída norte.
     * @param leste A saída leste.
     * @param sul A saída sul.
     * @param oeste A saída oeste.
     */
    public void ajustarSaida(String direcao, Ambiente ambiente)  {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }

    public Ambiente getSaida(String direcao) {
        return saidas.get(direcao);
    }

    public String getSaidas() {
        String textoSaidas = "";
        for(String direcao : saidas.keySet()) {
            textoSaidas = textoSaidas + direcao + " ";
        }
        return textoSaidas;
    }

    public boolean temItem() {
        return (item != null);
    }

    public void getDescricaoLonga() {
        System.out.println("Voce esta " + getDescricao());
        if(temItem()) {
            System.out.println("Nesse ambiente tem o item: " + item.getItem());
            System.out.println(item.getDescricao());
        } else {
            System.out.println("Nao tem nenhum item.");
        }
        System.out.print("Saidas: ");
        System.out.println(getSaidas());
    }

    public Item consultarItem() {
        if(item == null){
            return null;
        }
        return item;
    }

    public Item pegarItem() {
        Item aux = item;
        item = null;
        return aux;
    }

}
