package controllers;

import controllers.ProducaoController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class ProducaoIncluirController {

    private final ProducaoController producaoController = new ProducaoController();

    @FXML
    private TextField txtBrinco;

    @FXML
    private DatePicker dateData;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private void salvarProducao() {
        try {
            String brinco = txtBrinco.getText();
            LocalDate data = dateData.getValue();
            double quantidade = Double.parseDouble(txtQuantidade.getText());

            producaoController.registrarProducao(brinco, data, quantidade);

            mostrarMensagem("Produção registrada com sucesso!", Alert.AlertType.INFORMATION);
            limparCampos();
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

    private void limparCampos() {
        txtBrinco.clear();
        dateData.setValue(null);
        txtQuantidade.clear();
    }
}
