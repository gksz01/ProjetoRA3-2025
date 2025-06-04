package Views;

import Controllers.AlunoController;
import Models.Aluno;

import java.util.List;

public class PainelAluno extends PainelBase {
    private final AlunoController alunoController;

    public PainelAluno() {
        super("Aluno", "Email do Aluno", "Idade do Aluno");
        this.alunoController = new AlunoController();
    }

    @Override
    protected void configurarAcoes() {
        adicionarButton.setOnAction(e -> {
            try {
                String nome = nomeTextField.getText();
                String email = tipoTextField.getText();
                int idade = Integer.parseInt(custoTextField.getText());
                alunoController.createAluno(nome, email, idade);
                inputResult.setText("Aluno criado com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Erro ao criar aluno: " + ex.getMessage());
            }
        });

        listarButton.setOnAction(e -> {
            try {
                List<Aluno> alunos = alunoController.listarAlunos();
                StringBuilder builder = new StringBuilder();
                for (Aluno aluno : alunos) {
                    builder.append(aluno.toString()).append("\n");
                }
                inputResult.setText(!builder.isEmpty() ? builder.toString() : "Nenhum aluno cadastrado.");
            } catch (Exception ex) {
                inputResult.setText("Erro ao listar alunos: " + ex.getMessage());
            }
        });

        alterarButton.setOnAction(e -> {
            try {
                String nomeAntigo = nomeTextField.getText();
                String novoNome = nomeTextField.getText();
                String novoEmail = tipoTextField.getText();
                int novaIdade = Integer.parseInt(custoTextField.getText());
                alunoController.updateAluno(nomeAntigo, novoNome, novoEmail, novaIdade);
                inputResult.setText("Aluno atualizado com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Erro ao atualizar aluno: " + ex.getMessage());
            }
        });

        removerButton.setOnAction(e -> {
            try {
                String nome = nomeTextField.getText();
                alunoController.deleteAlunoByName(nome);
                inputResult.setText("Aluno removido com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Erro ao remover aluno: " + ex.getMessage());
            }
        });
    }
}
