import java.util.Scanner;

public class CaixaEletronico {

    private Scanner entrada = new Scanner(System.in);
    private Conta[] contaNova;

    public CaixaEletronico() {
        contaNova = new Conta[2];
    }
    
    public void menu() {
        int opcao=0;
        while(opcao != 8){
            System.out.println("");
            System.out.println("1. Criar Conta");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Render");
            System.out.println("7. Novo Rendimento");
            System.out.println("8. Sair");
            System.out.print("Digite qual opcao deseja: ");
            opcao = Integer.parseInt(entrada.nextLine());
            switch(opcao){
                case 1:
                    criarConta();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    transfererir();
                    break;
                case 6:
                    rendimento();
                    break;
                case 7:
                    mudarRendimento();
                    break;
                default:
                    break;
            }
        }
    }
    public void criarConta() {

        for(int i=0; i < 2; i++){
            System.out.print("Digite o nome do responsavel da conta: ");
            String nome = entrada.nextLine();
            System.out.print("Digite o cpf do responsavel da conta: ");
            String cpf = entrada.nextLine();
            Cliente cliente = new Cliente(cpf, nome);

            System.out.print("Deseja ter um saldo inicial? (Nao/Sim) ");
            String saldoinical = entrada.nextLine();

            if(saldoinical.equals("Nao")){
                contaNova[i] = new Conta(2000.0, cliente);
                System.out.println("\nConta criada com sucesso!");
                System.out.println("Numero da conta: " + contaNova[i].getNumeroConta());
            } else {
                System.out.print("Digite o saldo que deseja: ");
                double saldoin = Double.parseDouble(entrada.nextLine());
                contaNova[i] = new Conta(saldoin, 2000.0, cliente);
                System.out.println("\nConta criada com sucesso!");
                System.out.println("Numero da conta: " + contaNova[i].getNumeroConta() + "\n");
            }
        }
    }

    public void consultarSaldo() {
        System.out.print("Qual conta deseja constular? (Numero da conta): ");
        int qConta = Integer.parseInt(entrada.nextLine());
        
        for(Conta conta : contaNova) {
            if(conta.getNumeroConta() == qConta && conta != null) {
                System.out.print("Conta de " + conta.getCliente().getNome());
                System.out.print(" com cpf '" + conta.getCliente().getCpf());
                System.out.println("' tem " + conta.getSaldo() + " de saldo.");
                System.out.println("Numero da conta: " + conta.getNumeroConta());
                return;
            }
        }
        System.out.println("Conta nao criada!");
    }

    public void depositar() {
        System.out.print("Qual conta deseja depositar? (Numero da conta): ");
        int qConta = Integer.parseInt(entrada.nextLine());

        System.out.print("Digite a quantia que deseja depositar: ");
        double deposito = Double.parseDouble(entrada.nextLine());

        for(Conta conta : contaNova) {
            if(conta.getNumeroConta() == qConta && conta != null) {
                conta.deposito(deposito);
                return;
            }
        }
        System.out.println("Conta nao criada!");
    }

    public void sacar() {
        System.out.print("Qual conta deseja sacar? (Numero da conta): ");
        int qConta = Integer.parseInt(entrada.nextLine());

        System.out.print("Digite a quantia que deseja sacar: ");
        double sacar = Double.parseDouble(entrada.nextLine());

        for(Conta conta : contaNova) {
            if(conta.getNumeroConta() == qConta && conta != null) {
                if(!conta.saque(sacar)){
                    System.out.println("Nao tem saldo suficiente!");
                }
                return;
            }
        }
        System.out.println("Conta nao criada!");
    }

    public void transfererir() {
        System.out.print("Digite o numero da conta de origem: ");
        int qContaO = Integer.parseInt(entrada.nextLine());

        System.out.print("Digite o numero da conta de destino: ");
        int qContaD = Integer.parseInt(entrada.nextLine());

        System.out.print("Digite a quantia que deseja transferir: ");
        double quantia = Double.parseDouble(entrada.nextLine());

        int achou=0;
        for(int j=0; j < contaNova.length; j++){
            if(contaNova[j].getNumeroConta() == qContaD){
                achou = j;
            }
        }
        for(int i=0; i < contaNova.length; i++){
            if(contaNova[i].getNumeroConta() == qContaO){
                contaNova[i].transferencia(quantia, contaNova[achou]);
            }
        }
    }

    public void rendimento() {
        System.out.print("Digite o numero da conta que deseja render: ");
        int qConta = Integer.parseInt(entrada.nextLine());

        for(Conta conta : contaNova){
            if(conta.getNumeroConta() == qConta){
                conta.render();
            }
        }
    }

    public void mudarRendimento() {
        System.out.print("Digite a nova taxa de rendimento: ");
        int novaTaxa = Integer.parseInt(entrada.nextLine());
        contaNova[0].novoRendimento(novaTaxa);
    }
}
