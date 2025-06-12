package Views;

import Controllers.DisciplinaController;
import Models.Disciplina;

import java.util.List;

public class PainelDisciplina extends PainelBase {
    private DisciplinaController disciplinaController;
    public PainelDisciplina() {
        super("Disciplina","Horas aula da disciplina");
        this.disciplinaController = new DisciplinaController();
    }
    @Override
    protected void configurarAcoes(){
        adicionarButton.setOnAction(e -> {
            try{
                String nome = nomeTextField.getText();
                int horasAula = Integer.parseInt(horasAulaTextField.getText());
                disciplinaController.createDisciplina(nome, horasAula);
                inputResult.setText("Cadastro de disciplina realizado com sucesso!");
            } catch (Exception ex){
                inputResult.setText("Ocorreu um erro durante o cadastro da disciplina" + ex.getMessage());
            }
        });

        listarButton.setOnAction(e -> {
            try{
                List<Disciplina> disciplinas = disciplinaController.listarDisciplina();
                StringBuilder stringBuilder = new StringBuilder();
                for (Disciplina disciplina : disciplinas) {
                    stringBuilder.append(disciplina.toString()).append("\n");
                }
                inputResult.setText(!stringBuilder.isEmpty()
                        ? stringBuilder.toString()
                        : "Nenhuma disciplina cadastrado.");
            } catch (Exception ex){
                inputResult.setText("Ocorreu um erro ao processar a lista de disciplinas: " + ex.getMessage());
            }
        });
        alterarButton.setOnAction(e -> {
            try{
                String nome = nomeTextField.getText();
                String nomeNovo = nomeTextField.getText();
                int horasAula = Integer.parseInt(horasAulaTextField.getText());
                disciplinaController.updateDisciplina(nome, nomeNovo, horasAula);
                inputResult.setText("Cadastro de disciplina atualizado com sucesso!");
            }catch (Exception ex){
                inputResult.setText("Erro ao atualizar o cadastro da disciplina: " + ex.getMessage());
            }
        });
        removerButton.setOnAction(e -> {
            try {
                String nome = nomeTextField.getText();
                disciplinaController.deleteDisciplinaByName(nome);
            }catch (Exception ex){
                inputResult.setText("Erro ao deletar o cadastro da disciplina: " + ex.getMessage());
            }
        });
    }
}
