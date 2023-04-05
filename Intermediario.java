public class Intermediario extends Carro{
    private static String categoria = "Intermediario";
    public Intermediario(int id, String nome, String renavam, String anoFabricacao, int quantidade, double preco) {
        super(id, nome, renavam, categoria, anoFabricacao, quantidade, preco);
    }
}
