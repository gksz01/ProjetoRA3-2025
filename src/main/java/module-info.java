module com.example.projetora3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.projetora3 to javafx.fxml;
    exports com.example.projetora3;
}