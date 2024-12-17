package models;

import java.time.LocalDate;

public class Producao {
    private String brinco;
    private LocalDate data;
    private double quantidade;

    public Producao(String brinco, LocalDate data, double quantidade) {
        this.brinco = brinco;
        this.data = data;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public String getBrinco() { return brinco; }
    public void setBrinco(String brinco) { this.brinco = brinco; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public double getQuantidade() { return quantidade; }
    public void setQuantidade(double quantidade) { this.quantidade = quantidade; }
}
