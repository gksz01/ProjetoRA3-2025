package Controllers;

import Models.Aluno;
import Models.AlunoData;

import java.util.ArrayList;
import java.util.List;

public class AlunoController {
    private final List<Aluno> alunos;

    public AlunoController() {
        this.alunos = AlunoData.carregarAlunos();
    }

    public void createAluno(String nome, String email, int idade) {
        try {
            Aluno aluno = new Aluno(nome, email, idade);
            alunos.add(aluno);
            AlunoData.salvarAlunos(alunos);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao criar um novo aluno: " + e.getMessage());
        }
    }

    public List<Aluno> listarAlunos() {
        try {
            return new ArrayList<>(alunos);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar alunos: " + e.getMessage());
        }
    }

    public void updateAluno(String nomeAntigo, String novoNome, String novoEmail, int novaIdade) {
        try {
            for (Aluno aluno : alunos) {
                if (aluno.getNome().equalsIgnoreCase(nomeAntigo)) {
                    aluno.setNome(novoNome);
                    aluno.setEmail(novoEmail);
                    aluno.setIdade(novaIdade);
                    AlunoData.salvarAlunos(alunos);
                    return;
                }
            }
            throw new RuntimeException("Aluno não encontrado: " + nomeAntigo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    public void deleteAlunoByName(String nome) {
        try {
            Aluno alunoParaRemover = null;
            for (Aluno aluno : alunos) {
                if (aluno.getNome().equalsIgnoreCase(nome)) {
                    alunoParaRemover = aluno;
                    break;
                }
            }

            if (alunoParaRemover == null) {
                throw new RuntimeException("Aluno não encontrado: " + nome);
            }

            alunos.remove(alunoParaRemover);
            AlunoData.salvarAlunos(alunos);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar o aluno: " + e.getMessage());
        }
    }
}
