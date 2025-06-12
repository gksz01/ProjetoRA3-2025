package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public abstract class PainelBase extends VBox {
    protected TextField nomeTextField;
    protected TextField tipoTextField;
    protected TextField custoTextField;
    protected TextField idadeTextField;
    protected TextField generoTextField;
    protected TextArea inputResult;
    protected Button adicionarButton;
    protected Button listarButton;
    protected Button alterarButton;
    protected Button removerButton;

    public PainelBase(String nomeEntidade, String tipoEntidade, String valorEntidade) {
        setSpacing(15);
        setPadding(new Insets(15));
        setStyle("-fx-background-color: #f4f4f4;");

        Label titleLabel = new Label("Gerenciamento de " + nomeEntidade);
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");
        VBox titleBox = new VBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(10));

        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.setPadding(new Insets(15));
        inputGrid.setStyle("-fx-background-color: #ffffff; -fx-border-color: #ccc; -fx-border-radius: 5; -fx-background-radius: 5; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 2);");

        Label nomeLabel = new Label("Nome do " + nomeEntidade + ":");
        nomeLabel.setStyle("-fx-font-size: 14px;");
        nomeTextField = new TextField();
        nomeTextField.setPromptText("Ex.: Nome do " + nomeEntidade);

        Label tipoLabel = new Label(tipoEntidade + ":");
        tipoLabel.setStyle("-fx-font-size: 14px;");
        tipoTextField = new TextField();
        tipoTextField.setPromptText("Ex.: Tipo do " + nomeEntidade);

        Label custoLabel = new Label(valorEntidade + ":");
        custoLabel.setStyle("-fx-font-size: 14px;");
        custoTextField = new TextField();
        custoTextField.setPromptText("Ex.: 1500.00");

        inputGrid.add(nomeLabel, 0, 0);
        inputGrid.add(nomeTextField, 1, 0);
        inputGrid.add(tipoLabel, 0, 1);
        inputGrid.add(tipoTextField, 1, 1);
        inputGrid.add(custoLabel, 0, 2);
        inputGrid.add(custoTextField, 1, 2);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(15));

        adicionarButton = new Button("Adicionar " + nomeEntidade);
        listarButton = new Button("Listar " + nomeEntidade + "s");
        alterarButton = new Button("Alterar " + nomeEntidade);
        removerButton = new Button("Remover " + nomeEntidade);

        String buttonStyle = "-fx-font-size: 14px; -fx-padding: 8 15; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5; -fx-cursor: hand;";
        adicionarButton.setStyle(buttonStyle);
        listarButton.setStyle(buttonStyle.replace("#4CAF50", "#2196F3"));
        alterarButton.setStyle(buttonStyle.replace("#4CAF50", "#FFC107"));
        removerButton.setStyle(buttonStyle.replace("#4CAF50", "#F44336"));

        buttonBox.getChildren().addAll(adicionarButton, listarButton, alterarButton, removerButton);

        VBox resultBox = new VBox(10);
        resultBox.setPadding(new Insets(15));
        resultBox.setStyle("-fx-background-color: #ffffff; -fx-border-color: #ccc; -fx-border-radius: 5; -fx-background-radius: 5; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 2);");

        Label resultLabel = new Label("Resultados:");
        resultLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        inputResult = new TextArea();
        inputResult.setEditable(false);
        inputResult.setPrefHeight(150);

        resultBox.getChildren().addAll(resultLabel, inputResult);

        getChildren().addAll(titleBox, inputGrid, buttonBox, resultBox);

        configurarAcoes();
    }

    public PainelBase(String nomeEntidade, String idadeEntidade, String generoEntidade, boolean teste){
        setSpacing(15);
        setPadding(new Insets(15));
        setStyle("-fx-background-color: #f4f4f4;");

        Label titleLabel = new Label("Gerenciamento de " + nomeEntidade);
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");
        VBox titleBox = new VBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(10));

        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.setPadding(new Insets(15));
        inputGrid.setStyle("-fx-background-color: #ffffff; -fx-border-color: #ccc; -fx-border-radius: 5; -fx-background-radius: 5; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 2);");

        Label nomeLabel = new Label("Nome do " + nomeEntidade + ":");
        nomeLabel.setStyle("-fx-font-size: 14px;");
        nomeTextField = new TextField();
        nomeTextField.setPromptText("Ex.: Nome do " + nomeEntidade);

        Label idadeLabel = new Label(idadeEntidade + ":");
        idadeLabel.setStyle("-fx-font-size: 14px;");
        idadeTextField = new TextField();
        idadeTextField.setPromptText("Ex.: Idade do " + nomeEntidade);

        Label generoLabel = new Label(generoEntidade + ":");
        generoLabel.setStyle("-fx-font-size: 14px;");
        generoTextField = new TextField();
        generoTextField.setPromptText("Ex.: M/F");

        inputGrid.add(nomeLabel, 0, 0);
        inputGrid.add(nomeTextField, 1, 0);
        inputGrid.add(idadeLabel, 0, 1);
        inputGrid.add(idadeTextField, 1, 1);
        inputGrid.add(generoLabel, 0, 2);
        inputGrid.add(generoTextField, 1, 2);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(15));

        adicionarButton = new Button("Adicionar " + nomeEntidade);
        listarButton = new Button("Listar " + nomeEntidade + "s");
        alterarButton = new Button("Alterar " + nomeEntidade);
        removerButton = new Button("Remover " + nomeEntidade);

        String buttonStyle = "-fx-font-size: 14px; -fx-padding: 8 15; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5; -fx-cursor: hand;";
        adicionarButton.setStyle(buttonStyle);
        listarButton.setStyle(buttonStyle.replace("#4CAF50", "#2196F3"));
        alterarButton.setStyle(buttonStyle.replace("#4CAF50", "#FFC107"));
        removerButton.setStyle(buttonStyle.replace("#4CAF50", "#F44336"));

        buttonBox.getChildren().addAll(adicionarButton, listarButton, alterarButton, removerButton);

        VBox resultBox = new VBox(10);
        resultBox.setPadding(new Insets(15));
        resultBox.setStyle("-fx-background-color: #ffffff; -fx-border-color: #ccc; -fx-border-radius: 5; -fx-background-radius: 5; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 2);");

        Label resultLabel = new Label("Resultados:");
        resultLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        inputResult = new TextArea();
        inputResult.setEditable(false);
        inputResult.setPrefHeight(150);

        resultBox.getChildren().addAll(resultLabel, inputResult);

        getChildren().addAll(titleBox, inputGrid, buttonBox, resultBox);

        configurarAcoes();
    }

    protected abstract void configurarAcoes();
}