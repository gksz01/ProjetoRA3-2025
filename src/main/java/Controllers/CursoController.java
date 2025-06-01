package Controllers;

import Models.Curso;
import Models.CursoData;

import java.util.ArrayList;
import java.util.List;

public class CursoController {
    private final List<Curso> cursos;

    public CursoController(){
        this.cursos = CursoData.carregarCursos();
    }

    public void createCurso(String nome, String tipoCurso, double custo){
        try{
            Curso curso = new Curso(nome, tipoCurso, custo);
            cursos.add(curso);
            CursoData.salvarCursos(cursos);
        }catch (Exception e){
            throw new RuntimeException("Ocorreu um erro ao criar um novo curso: " + e.getMessage());
        }
    }

    public List<Curso> listarCursos() {
        try {
            return new ArrayList<>(cursos);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao listar os cursos: " + e.getMessage());
        }
    }

    public void updateCurso(String nomeAntigo, String nomeNovo, String novoTipoCurso, double novoCusto){
        try{
            for(Curso curso : cursos){
                if(curso.getNome().equals(nomeAntigo)){
                    curso.setNome(nomeNovo);
                    curso.setTipoCurso(novoTipoCurso);
                    curso.setCusto(novoCusto);
                    CursoData.salvarCursos(cursos);
                    return;
                }
            }
            throw new RuntimeException("O curso: " + nomeAntigo + "Não foi encontrado!");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao tentar atualizar o curso: " + e.getMessage());
        }
    }

    public void deleteCursoByName(String nome){
        try{
            Curso cursoToRemove = null;
            for(Curso curso : cursos){
                if(curso.getNome().equals(nome)){
                    cursoToRemove = curso;
                    break;
                }
            }

            if(cursoToRemove == null){
                throw new RuntimeException("Curso não encontrado" + nome);
            }

            cursos.remove(cursoToRemove);
            CursoData.salvarCursos(cursos);
        }catch (Exception e){
            throw new RuntimeException("Erro ao deleter o curso: " + e.getMessage());
        }
    }
}
