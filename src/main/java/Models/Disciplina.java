package Models;

import java.io.Serial;
import java.io.Serializable;

public class Disciplina implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String Nome;
    private int HorasAula;

    public Disciplina(String nome, int horasAula) {
        this.Nome = nome;
        this.HorasAula = horasAula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome){
        this.Nome = nome;
    }

    public int getHorasAula() {
        return HorasAula;
    }

    public void setHorasAula(int horasAula){
        this.HorasAula = horasAula;
    }

    @Override
    public String toString() {
        return Nome + "," + HorasAula;
    }
}