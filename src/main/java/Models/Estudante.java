package Models;

public class Estudante {
    private String nome;
    private double idade;
    private String genero;

    public Estudante(String nome, double idade, String genero) {
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
    public void setIdade(double idade) {
        this.idade = idade;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

}
