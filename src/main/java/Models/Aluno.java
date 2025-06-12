package Models;

import java.io.Serial;
import java.io.Serializable;

public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private String email;
    private int idade;

    public Aluno(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    @Override
    public String toString() {
        return nome + "," + email + "," + idade;
    }
}
