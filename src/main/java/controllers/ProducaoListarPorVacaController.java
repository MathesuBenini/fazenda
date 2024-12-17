package controllers;

import controllers.ProducaoController;
import models.Producao;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.Month;
import java.util.List;

public class ProducaoListarPorVacaController {

    private final ProducaoController producaoController = new ProducaoController();

    @FXML
    private TextField txtBrinco;

    @FXML
    private ComboBox<String> cmbMes;

    @FXML
    private ComboBox<String> cmbAno;

    @FXML
    private TableView<Producao> tableProducao;

    @FXML
    private TableColumn<Producao, String> colData;

    @FXML
    private TableColumn<Producao, Double> colQuantidade;

    @FXML
    private void initialize() {
        // Inicializa os valores dos ComboBoxes
        cmbMes.setItems(FXCollections.observableArrayList(
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"));
        cmbAno.setItems(FXCollections.observableArrayList("2023", "2024"));
    }

    @FXML
    private void listarProducaoPorVaca() {
        try {
            String brinco = txtBrinco.getText();
            int mes = cmbMes.getSelectionModel().getSelectedIndex() + 1;
            int ano = Integer.parseInt(cmbAno.getValue());

            List<Producao> producoes = producaoController.consultarProducaoPorAnimal(brinco, mes, ano);
            ObservableList<Producao> data = FXCollections.observableArrayList(producoes);

            tableProducao.setItems(data);
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
