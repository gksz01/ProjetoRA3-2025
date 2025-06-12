package Views;

import Controllers.EstudanteController;
import Models.Estudante;

import java.util.List;

public class PainelEstudante extends PainelBase {
    private EstudanteController estudanteControler;

    public PainelEstudante() {
        super("Estudante", "Idade do estudante", "Gênero do estudante", false);
        this.estudanteControler = new EstudanteController();
    }

    @Override
    protected void configurarAcoes() {
        adicionarButton.setOnAction(e -> {
            try {
                String nome = nomeTextField.getText();
                int idade = Integer.parseInt(idadeTextField.getText());
                String genero = generoTextField.getText();
                estudanteControler.createEstudante(nome, idade, genero);
                inputResult.setText("Cadastro de estudante realizado com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Ocorreu um erro durante o cadastro do estudante: " + ex.getMessage());
            }
        });

        listarButton.setOnAction(e -> {
            try {
                List<Estudante> estudantes = estudanteControler.listarEstudantes();
                StringBuilder stringBuilder = new StringBuilder();
                for (Estudante estudante : estudantes) {
                    stringBuilder.append(estudante.toString()).append("\n");
                }
                inputResult.setText(!stringBuilder.isEmpty()
                        ? stringBuilder.toString()
                        : "Nenhum estudante cadastrado.");
            } catch (Exception ex) {
                inputResult.setText("Ocorreu um erro ao processar a lista de estudantes: " + ex.getMessage());
            }
        });

        alterarButton.setOnAction(e -> {
            try {
                String nome = nomeTextField.getText();
                int idade = Integer.parseInt(idadeTextField.getText());
                String genero = generoTextField.getText();
                estudanteControler.updateEstudante(nome, nome, idade, genero);
                inputResult.setText("Cadastro de estudante atualizado com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Erro ao atualizar o cadastro do estudante: " + ex.getMessage());
            }
        });

        removerButton.setOnAction(e -> {
            try {
                String nome = nomeTextField.getText();
                estudanteControler.deleteEstudanteByName(nome);
                inputResult.setText("Cadastro de estudante removido com sucesso!");
            } catch (Exception ex) {
                inputResult.setText("Erro ao deletar o cadastro do estudante: " + ex.getMessage());
            }
        });
    }
}
