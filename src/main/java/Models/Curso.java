package Models;

import java.io.Serial;
import java.io.Serializable;

public class Curso implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String Nome;
    private String TipoCurso;
    private double Custo;

    public Curso(String nome, String tipoCurso, double Custo) {
        this.Nome = nome;
        this.TipoCurso = tipoCurso;
        this.Custo = Custo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome){
        this.Nome = nome;
    }

    public String getTipoCurso() {
        return TipoCurso;
    }

    public void setTipoCurso(String tipoCurso){
        this.TipoCurso = tipoCurso;
    }

    public double getCusto() {
        return Custo;
    }

    public void setCusto(double Custo) {
        this.Custo = Custo;
    }

    @Override
    public String toString() {
        return Nome + "," + TipoCurso + "," + Custo;
    }
}
