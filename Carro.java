public class Carro {
    private String nome;
    private String renavam;
    private String categoria;
    private String anoFabricacao;
    private int quantidade;
    private double preco;

    public Carro(String nome, String renavam, String categoria, String anoFabricacao, int quantidade, double preco) {
        this.nome = nome;
        this.renavam = renavam;
        this.categoria = categoria;
        this.anoFabricacao = anoFabricacao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Carro () {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Carro{" + "nome=" + nome + ", renavam=" + renavam + ", categoria=" + categoria + ", anoFabricacao=" + anoFabricacao + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }


}