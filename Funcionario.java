public class Funcionario extends User {
    private static String tipo = "Funcionario";

    public Funcionario(String nome, String login, String senha) {
        super(nome, login, senha, tipo);
    }
}
