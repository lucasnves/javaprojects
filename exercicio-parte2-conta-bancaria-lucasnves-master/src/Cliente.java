public class Cliente {
    private String cpf;
    private String nome;

    public Cliente(String cpfN, String nomeN) {
        cpf = cpfN;
        nome = nomeN;  
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
