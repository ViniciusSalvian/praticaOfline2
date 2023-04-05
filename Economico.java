
public class Economico extends Carro{
    private static String categoria = "Economico";
    public Economico(int id, String nome, String renavam, String anoFabricacao, int quantidade, double preco) {
        super(id, nome, renavam, categoria, anoFabricacao, quantidade, preco);
    }
}
