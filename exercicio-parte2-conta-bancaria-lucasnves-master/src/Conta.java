public class Conta {
    private double saldoLimite;
    private double saldo;
    private Cliente novoCliente;
    private static int contadorConta;
    private int numeroConta;
    private static double rendimento;

    public Conta(Double saldoL, Cliente clienteN){
        this(0.0, saldoL, clienteN);
    }

    public Conta(Double saldoI, Double saldoL, Cliente clienteN){
        this.saldo = saldoI;
        this.saldoLimite = saldoL;
        this.novoCliente = clienteN;
        this.numeroConta = jaCriou();
        rendimento = 2.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return novoCliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public boolean saque(double saque) {
        if(saldo-saque >= -saldoLimite){
            saldo -= saque;
            return true;
        }
        return false;
    }

    public void deposito(double depositar) {
        saldo+= depositar;
    }

    public int jaCriou(){
        if (contadorConta != 0){
            contadorConta++;
        } else {
            contadorConta = 101;
        }
        return contadorConta;
    }

    public void transferencia(double quantia, Conta clienteN) {
        if(!saque(quantia)){
            System.out.println("Nao foi possivel, atingiu o limite da conta de origem.");
        } else {
            clienteN.deposito(quantia);
        }
    }

    public void render() {
        saldo = saldo + (saldo * (rendimento/100));
    }

    public void novoRendimento(int nRendimento) {
       rendimento = nRendimento;
    }
}
