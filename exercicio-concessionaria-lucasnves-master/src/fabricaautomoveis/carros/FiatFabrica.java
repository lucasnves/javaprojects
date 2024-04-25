package fabricaautomoveis.carros;

public class FiatFabrica extends FabricaCarro {

    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        if (categoria == Categoria.POPULAR) {
            carro = new Argo(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Toro(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            carro = new Strada(cor);
        }
        return carro;
    }
}
