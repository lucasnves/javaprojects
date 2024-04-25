package fabricaautomoveis.carros;

public class VWFabrica extends FabricaCarro {
    
    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro = null;

        if (categoria == Categoria.PICKUP) {
            carro = new Saveiro(cor);
        }
        else if (categoria == Categoria.POPULAR) {
            carro = new Gol(cor);
        }
        return carro;
    }
}
