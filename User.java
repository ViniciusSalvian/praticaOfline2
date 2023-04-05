import java.io.Serializable;

public class User implements Serializable{
    
    private String nome;
    private String login;
    private String senha;
    private String tipo;

    public User(String nome, String login, String senha, String tipo) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    


    public String toString() {
        return "User [nome=" + nome + ", login=" + login + ", tipo=" + tipo + "]";
    }

}
