public class UserCliente extends User {
    private static String tipo = "Cliente";
    public UserCliente(String nome, String login, String senha) {
        super(nome, login, senha, tipo);
        
    }
    
}
