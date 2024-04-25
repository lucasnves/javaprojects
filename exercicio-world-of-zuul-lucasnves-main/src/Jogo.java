/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser 
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */


public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;

    private Explorador jogador;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo()  {
        criarAmbientes();
        analisador = new Analisador();
        jogador = new Explorador("Lucas");
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente gramado, floresta, parque, lago, restaurantes;

        // cria os ambientes
        gramado = new Ambiente("em um espaco aberto, um gramado, em frente ao lago");
        floresta = new Ambiente("na floresta escura", "Flor-preta", "Uma flor rara e poderosa para usar como defesa.");
        parque = new Ambiente("no parque com varios brinquedos");
        lago = new Ambiente("no lago com alguns animais doceis");
        restaurantes = new Ambiente("em um ambiente com varios restaurantes", "Cachorro-quente", "No restaurante tem um cachorro quente maravilhoso, experimente e ganhe forcas para explorar mais.");
        
        // inicializa as saidas dos ambientes
        // NORTE LESTE SUL OESTE
        gramado.ajustarSaida("leste", floresta);
        gramado.ajustarSaida("sul", lago);
        gramado.ajustarSaida("oeste", parque);
        floresta.ajustarSaida("oeste", gramado);
        parque.ajustarSaida("leste", gramado);
        lago.ajustarSaida("norte", gramado);
        lago.ajustarSaida("leste", restaurantes);
        restaurantes.ajustarSaida("oeste", lago);

        ambienteAtual = gramado;  // o jogo comeca em frente à gramado
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo ao Park Challenge");
        System.out.println("Park Challenge e um jogo de exploracao em busca de um item dentro do parque, explore e divarta-se.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        
        localAtual();    
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        } 
        else if (palavraDeComando.equals("observar")) {
            ambienteAtual.getDescricaoLonga();
        } 
        else if (palavraDeComando.equals("pegar")) {
            pegandoItem(comando);
        }
        else if (palavraDeComando.equals("inventario")) {
            exiba();
        } 

        return querSair;
    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  {
        System.out.println("\nVoce esta em um parque, com amigos e estao em busca de um item para assim ganhar o desafio, explore o parque para achalo-lo.");
        System.out.println("Alguns comandos para auxilia-lo");
        String comandosTexto = "- ";
        for(int i=0; i < analisador.comandosValidos().length; i++) {
            comandosTexto += "'" + analisador.comandosValidos()[i] + "' ";
        }
        System.out.println(comandosTexto);
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando)  {
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        proximoAmbiente = ambienteAtual.getSaida(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            
            localAtual();
        }
    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }

    private void localAtual() {
        System.out.println("Voce esta " + ambienteAtual.getDescricao());

        System.out.print("Saidas: ");
        System.out.println(ambienteAtual.getSaidas());
    }

    private void pegandoItem(Comando comando) {

        if(!comando.temSegundaPalavra()) {            
            System.out.println("Pegar o que?");
            return;
        }
        String item = comando.getSegundaPalavra();
        if(ambienteAtual.consultarItem() != null && ambienteAtual.consultarItem().getItem().equals(item)){
            System.out.println("Item " + ambienteAtual.consultarItem().getItem() + " pegado com sucesso!");
            jogador.addItem(ambienteAtual.consultarItem().getItem());
            ambienteAtual.pegarItem();
        }  else {
            System.out.println("Nao ha itens no ambiente");
        }
    }

    public void exiba() {
        if(jogador.itensMochila().length() > 0) {
            System.out.print("Itens no seu inventario: ");
            System.out.println(jogador.itensMochila());
        } else {
            System.out.println("Sem itens no inventario!");
        }
        
    }
}
