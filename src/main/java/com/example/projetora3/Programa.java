package com.example.projetora3;

import Views.PainelAluno;
import Views.PainelCurso;
import Views.PainelEstudante;
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

        Tab tabEstudantes = new Tab("Estudantes");
        PainelEstudante painelEstudante = new PainelEstudante();
        tabEstudantes.setContent(painelEstudante);

        Tab tabAluno = new Tab("Alunos");
        PainelAluno painelAluno = new PainelAluno();
        tabAluno.setContent(painelAluno);

        tabPane.getTabs().addAll(tabCursos, tabEstudantes, tabAluno);

        Scene scene = new Scene(tabPane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}