package models;

public class User {

    private String nome;
    private int id;
    private String email;
    private String senha;

    public User(String nome, int id, String email, String senha) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public User(){};

    @Override
    public String toString() {
        return "models.User: " +
                "nome: " + nome +
                "id: " + id +
                "email: " + email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
