package corredores;

public class Corredor implements Competidor {
    private String nome;
    private int velocidade;
    private int distanciaPercorrida;
    private boolean estaCorrendo;
    private int distanciaDaCorrida;

    public Corredor(String nome, int velocidade) {
        this.nome = nome;
        this.velocidade = velocidade;
        distanciaPercorrida = 0;
        estaCorrendo = false;
        distanciaDaCorrida = 0;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public boolean estaCorrendo() {
        return estaCorrendo;
    }

    @Override
    public void prepararParaNovaCorrida(int distanciaDaCorrida) {
        estaCorrendo = false;
        distanciaPercorrida = 0;
        this.distanciaDaCorrida = distanciaDaCorrida;
    }

    @Override
    public void run() {
        estaCorrendo = true;
        int tempoNec = (1000/velocidade);

        while (distanciaDaCorrida > distanciaPercorrida) {
            try {
                Thread.sleep(tempoNec);
                distanciaPercorrida += 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int getdistanciaDaCorrida() {
        return distanciaDaCorrida;
    }
}
