package Controllers;

import Models.Disciplina;
import Models.DisciplinaData;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaController {
    private final List<Disciplina> disciplinas;

    public DisciplinaController(){
        this.disciplinas = DisciplinaData.carregarDisciplinas();
    }

    public void createDisciplina(String nome, int horasAula){
        try{
            Disciplina disciplina = new Disciplina(nome, horasAula);
            disciplinas.add(disciplina);
            DisciplinaData.salvarDisciplina(disciplinas);
        }catch (Exception e){
            throw new RuntimeException("Ocorreu um erro ao criar um novo curso: " + e.getMessage());
        }
    }

    public List<Disciplina> listarDisciplina() {
        try {
            return new ArrayList<>(disciplinas);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao listar as disciplinas: " + e.getMessage());
        }
    }

    public void updateDisciplina(String nomeAntigo, String nomeNovo, int novoHorasAula){
        try{
            for(Disciplina disciplina : disciplinas){
                if(disciplina.getNome().equals(nomeAntigo)){
                    disciplina.setNome(nomeNovo);
                    disciplina.setHorasAula(novoHorasAula);
                    DisciplinaData.salvarDisciplina(disciplinas);
                    return;
                }
            }
            throw new RuntimeException("A disciplina: " + nomeAntigo + "Não foi encontrada!");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao tentar atualizar a disciplina: " + e.getMessage());
        }
    }

    public void deleteDisciplinaByName(String nome){
        try{
            Disciplina disciplinaToRemove = null;
            for(Disciplina disciplina : disciplinas){
                if(disciplina.getNome().equals(nome)){
                    disciplinaToRemove = disciplina;
                    break;
                }
            }

            if(disciplinaToRemove == null){
                throw new RuntimeException("Disciplina não encontrado" + nome);
            }

            disciplinas.remove(disciplinaToRemove);
            DisciplinaData.salvarDisciplina(disciplinas);
        }catch (Exception e){
            throw new RuntimeException("Erro ao deleter a disciplina: " + e.getMessage());
        }
    }
}
