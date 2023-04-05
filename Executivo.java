
public class Executivo extends Carro{
    private static String categoria = "Executivo";
    public Executivo(int id, String nome, String renavam, String anoFabricacao, int quantidade, double preco) {
        super(id, nome, renavam, categoria, anoFabricacao, quantidade, preco);
    }
}
