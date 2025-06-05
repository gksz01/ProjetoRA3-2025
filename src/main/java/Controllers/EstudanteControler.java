package Controllers;

import Models.Curso;
import Models.CursoData;
import Models.Estudante;
import Models.EstudanteData;

import java.util.ArrayList;
import java.util.List;

public class EstudanteControler {
    private final List<Estudante> estudantes;

    public EstudanteControler() {
        this.estudantes = new ArrayList<>();
    }

    public void createEstudante(String nome, double idade, String genero) {
        try {
            Estudante estudante = new Estudante(nome, idade, genero);
            estudantes.add(estudante);
            EstudanteData.salvarEstudante(estudantes);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao criar um novo estudante: " + e.getMessage());
        }

    }

    public List<Estudante> listarEstudantes() {
        try {
            return new ArrayList<>(estudantes);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao listar os estudantes: " + e.getMessage());
        }
    }

    public void updateEstudante(String nome, double idade, String genero) {
        try {

            for (Estudante estudante : estudantes) {
                if (estudante.getNome().equals(nome) && estudante.getIdade() == idade) {
                    estudante.setNome(nome);
                }
                if (estudante.getIdade() == idade) {
                    estudante.setIdade(idade);
                }
                if (estudante.getGenero().equals(genero)) {
                    estudante.setGenero(genero);
                    EstudanteData.salvarEstudante(estudantes);
                }
            }
            throw new RuntimeException("O curso: " + nome + "Não foi encontrado!");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao tentar atualizar o curso: " + e.getMessage());
        }
    }

    public void deleteEstudanteByName(String nome) {
        try {
            Estudante estudanteToRemove = null;
            for (Estudante estudante : estudantes) {
                if (estudante.getNome().equals(nome)) {
                    estudanteToRemove = estudante;
                    break;
                }
            }

            if (estudanteToRemove == null) {
                throw new RuntimeException("Curso não encontrado" + nome);
            }

            estudantes.remove(estudanteToRemove);
            EstudanteData.salvarEstudante(estudantes);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deleter o cadastro do estudante: " + e.getMessage());
        }


    }
}
