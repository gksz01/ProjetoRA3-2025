package Views;

import Controllers.CursoController;
import Models.Curso;

import java.util.List;

public class PainelCurso extends PainelBase {
    private CursoController cursoController;

    public PainelCurso() {
        super("Curso", "Tipo do Curso", "Custo do Curso");
        this.cursoController = new CursoController();
    }

    @Override
    protected void configurarAcoes() {
        adicionarButton.setOnAction(e -> {
            try {
                String nome = nomeTextField.getText();
                String tipoCurso = tipoTextField.getText();
                double custo = Double.parseDouble(custoTextField.getText());
                cursoController.createCurso(nome, tipoCurso, custo);
                inputResult.setText("Curso criado com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Ocorreu um erro durante a criação do curso: " + ex.getMessage());
            }
        });

        listarButton.setOnAction(e -> {
            try {
                List<Curso> cursos = cursoController.listarCursos();
                StringBuilder builder = new StringBuilder();
                for (Curso curso : cursos) {
                    builder.append(curso.toString()).append("\n");
                }
                inputResult.setText(!builder.isEmpty() ? builder.toString() : "Nenhum curso cadastrado.");
            } catch (Exception ex) {
                inputResult.setText("Ocorreu um erro ao listar os cursos: " + ex.getMessage());
            }
        });

        alterarButton.setOnAction(e -> {
            try {
                String nomeAntigo = nomeTextField.getText();
                String novoNome = nomeTextField.getText();
                String novoTipo = tipoTextField.getText();
                double custo = Double.parseDouble(custoTextField.getText());
                cursoController.updateCurso(nomeAntigo, novoNome, novoTipo, custo);
                inputResult.setText("Curso alterado com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Erro ao atualizar o curso: " + ex.getMessage());
            }
        });

        removerButton.setOnAction(e -> {
            try {
                String nome = nomeTextField.getText();
                cursoController.deleteCursoByName(nome);
                inputResult.setText("Curso removido com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Erro ao remover o curso: " + ex.getMessage());
            }
        });
    }
}