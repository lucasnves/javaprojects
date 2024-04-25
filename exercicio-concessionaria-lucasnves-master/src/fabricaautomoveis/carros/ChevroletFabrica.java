package fabricaautomoveis.carros;

public class ChevroletFabrica extends FabricaCarro {
    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        if (categoria == Categoria.POPULAR) {
            carro = new Onix(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Camaro(cor);
        }
        return carro;
    }
}
