package Models;

import java.io.Serial;
import java.io.Serializable;

public class Estudante implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;
    private String genero;

    public Estudante(String nome, int idade, String genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return nome + "," + idade + "," + genero;
    }

}