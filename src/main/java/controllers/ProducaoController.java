package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.App;
import javafx.fxml.FXML;
import javafx.application.Platform;
import models.Producao;

/**
 * Controlador para gerenciar telas relacionadas à produção.
 * @author Jose
 */
public class ProducaoController {

    @FXML
    private void producaoIncluir() throws IOException {
        App.setRoot("producaoIncluir"); // Carrega a tela de inclusão de produção
    }

    @FXML
    private void producaoListarPorVaca() throws IOException {
        App.setRoot("producaoListarPorVaca"); // Carrega a tela de listagem por vaca
    }

    @FXML
    private void voltarMenu() throws IOException {
        App.setRoot("menu"); // Retorna para o menu principal
    }

    @FXML
    private void sair() {
        Platform.exit();
        System.exit(0); // Fecha a aplicação
    }

    public void registrarProducao(String brinco, LocalDate data, double quantidade) {
    }

    public List<Producao> consultarProducaoPorAnimal(String brinco, int mes, int ano) {
        return List.of();
    }
}
