package com.example.projetora3;

import Views.PainelCurso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Programa extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Sistema de Gerenciamento");

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); // Impede o fechamento das abas

        Tab tabCursos = new Tab("Cursos");
        PainelCurso painelCurso = new PainelCurso();
        tabCursos.setContent(painelCurso);

        Tab tabAlunos = new Tab("Alunos");
        Tab tabProfessores = new Tab("Professores");
        Tab tabDisciplinas = new Tab("Disciplinas");

        tabPane.getTabs().addAll(tabCursos, tabAlunos, tabProfessores, tabDisciplinas);

        Scene scene = new Scene(tabPane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}