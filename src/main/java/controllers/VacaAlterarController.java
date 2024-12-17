package controllers;

import controllers.AnimalController;
import models.Vaca;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class VacaAlterarController {

    private final AnimalController animalController = new AnimalController();

    @FXML
    private TextField txtBrinco;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtRaca;

    @FXML
    private void vacaAlterar() {
        try {
            String brinco = txtBrinco.getText();
            String nome = txtNome.getText();
            String raca = txtRaca.getText();

            animalController.alterarAnimal(brinco, nome, raca);

            mostrarMensagem("Vaca alterada com sucesso!", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            mostrarMensagem("Erro: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }



    private void mostrarMensagem(String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
