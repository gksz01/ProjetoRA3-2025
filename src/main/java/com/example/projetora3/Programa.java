package com.example.projetora3;

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
        Tab tabEstudantes = new Tab("Estudantes");
        PainelCurso painelCurso = new PainelCurso();
        PainelEstudante painelEstudante = new PainelEstudante();
        tabCursos.setGraphic(painelCurso);
        tabCursos.setContent(painelCurso);

        Tab crudLyra = new Tab("Lyra");
        Tab crudGus = new Tab("Gustavo");
        Tab crudRava = new Tab("Ravenda");

        tabPane.getTabs().addAll(tabCursos, crudLyra, crudGus, crudRava);

        Scene scene = new Scene(tabPane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}