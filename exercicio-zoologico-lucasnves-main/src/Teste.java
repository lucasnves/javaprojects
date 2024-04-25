public class Teste {
    public static void main(String[] args) throws Exception {
        Animal animal = new Leao("Lea", "Azul");
        System.out.println(animal.getNome());
        animal = new Arara("Suele", "ruim");
        System.out.println(animal.getNome());
        animal = new Leao("Lea", "preto");
        System.out.println(exibirDescricaoCompleta(animal));
        animal = new Ema("Roberto", "bem");
        System.out.println(exibirDescricaoCompleta(animal));
    }

    public static String exibirDescricaoCompleta(Animal animal) {
        return animal.descricaoLonga();
    }
}
