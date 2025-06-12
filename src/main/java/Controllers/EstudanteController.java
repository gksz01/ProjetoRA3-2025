package Controllers;

import Models.Estudante;
import Models.EstudanteData;

import java.util.ArrayList;
import java.util.List;

public class EstudanteController {
    private final List<Estudante> estudantes;

    public EstudanteController() {
        this.estudantes = new ArrayList<>();
    }

    public void createEstudante(String nome, int idade, String genero) {
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

    public void updateEstudante(String nomeAntigo, String novoNome, int novaIdade, String novoGenero) {
        try {
            for (Estudante estudante : estudantes) {
                if (estudante.getNome().equals(nomeAntigo)) {
                    estudante.setNome(novoNome);
                    estudante.setIdade(novaIdade);
                    estudante.setGenero(novoGenero);
                    EstudanteData.salvarEstudante(estudantes);
                    return;
                }
            }
            throw new RuntimeException("O estudante: " + nomeAntigo + " não foi encontrado!");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao tentar atualizar o estudante: " + e.getMessage());
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
