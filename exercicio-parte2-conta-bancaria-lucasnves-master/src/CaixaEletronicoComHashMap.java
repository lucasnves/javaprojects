import java.util.Scanner;
import java.util.HashMap;

public class CaixaEletronicoComHashMap {
    private Scanner entrada = new Scanner(System.in);
    private HashMap<Conta, Conta> contas;

    public CaixaEletronicoComHashMap() {
        contas = new HashMap<>();
    }
    
    public void menu() {
        int opcao=0;
        while(opcao != 11){
            System.out.println("");
            System.out.println("1. Criar Conta");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Render");
            System.out.println("7. Novo Rendimento");
            System.out.println("8. Consultar todas contas");
            System.out.println("9. Remover conta");
            System.out.println("10. Filtra contas");
            System.out.println("11. Sair");
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
                case 8:
                    todasContas();
                    break;
                case 9:
                    removerConta();
                    break;
                case 10:
                    filtrarContas();
                default:
                    break;
            }
        }
    }
    public void criarConta() {
        boolean criar= true;
        while(criar) {
            System.out.print("\nDigite o nome do responsavel da conta: ");
            String nome = entrada.nextLine();
            System.out.print("Digite o cpf do responsavel da conta: ");
            String cpf = entrada.nextLine();
            Cliente cliente = new Cliente(cpf, nome);

            System.out.print("Deseja ter um saldo inicial? (Nao/Sim) ");
            String saldoinical = entrada.nextLine();

            if(saldoinical.equals("Nao")){
                contas.put(conta.getNumeroConta(), new Conta(2000.0, cliente));
            } else {
                System.out.print("Digite o saldo que deseja: ");
                double saldoin = Double.parseDouble(entrada.nextLine());
                contas.add(new Conta(saldoin, 2000.0, cliente));
            }

            System.out.print("\nDeseja criar outra conta? (Sim ou Nao) ");
            String cria = entrada.nextLine();
            if(!cria.equals("Sim")){
                criar = false;
            }
        }
        System.out.println("\nContas criadas com sucesso!");
    }

    public void consultarSaldo() {
        System.out.print("Qual conta deseja constular? (Numero da conta): ");
        int qConta = Integer.parseInt(entrada.nextLine());
        
        for(Conta conta : contas) {
            if(conta.getNumeroConta() == qConta && conta != null) {
                System.out.print("\n" + conta.getNumeroConta() + " - " + conta.getCliente().getNome());
                System.out.print(" com cpf '" + conta.getCliente().getCpf());
                System.out.println("' tem " + conta.getSaldo() + " de saldo.");
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

        for(Conta conta : contas) {
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

        for(Conta conta : contas) {
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

        for (Conta conta : contas) {
            if(conta.getNumeroConta() == qContaD){
                for (Conta conta2 : contas ) {
                    if(conta2.getNumeroConta() == qContaO) {
                        conta2.transferencia(quantia, conta);
                    }
                }
            }
        }
    }

    public void rendimento() {
        System.out.print("Digite o numero da conta que deseja render: ");
        int qConta = Integer.parseInt(entrada.nextLine());

        for(Conta conta : contas){
            if(conta.getNumeroConta() == qConta){
                conta.render();
            }
        }
    }

    public void mudarRendimento() {
        /*
        System.out.print("Digite a nova taxa de rendimento: ");
        Integer novaTaxa = Integer.parseInt(entrada.nextLine());
        contas.get(0).novoRendimento(novaTaxa);
        */
    }

    public void todasContas() {
        for(Conta conta : contas) {
            System.out.println(conta.getNumeroConta() + " - " + conta.getCliente().getNome());
        }
    }

    public void removerConta() {
        System.out.print("Digite o numero da conta que deseja remover: ");
        int qConta = Integer.parseInt(entrada.nextLine());
        int i=0;
        for(Conta conta : contas) {
            if(conta.getNumeroConta() == qConta && conta.getSaldo() == 0.0){
                contas.remove(i);
                System.out.println("Conta cancelada com sucesso!");
            } else if(conta.getSaldo() > 0.0 && conta.getNumeroConta() == qConta){
                System.out.println("Nao e possivel cancelar contas com saldo disponivel");
            } else if(conta.getSaldo() < 0.0 && conta.getNumeroConta() == qConta){
                System.out.println("Nao e possivel cancelar contas em debito");
            }
            i++;
        }
    }

    public void filtrarContas() {
        System.out.print("Digite nome do cliente ou uma parte do nome: ");
        String nome = entrada.nextLine().toUpperCase();

        for(Conta conta : contas) {
            if(conta.getCliente().getNome().toUpperCase().contains(nome)) {
                System.out.println(conta.getNumeroConta() + " - " + conta.getCliente().getNome());
            }
        }
    }
}
