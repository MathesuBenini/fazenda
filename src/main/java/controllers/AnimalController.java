package controllers;

import controllers.AnimalController;
import models.Vaca;
import repositories.AnimalRepository;

import java.util.List;

public class AnimalController {
    private final AnimalRepository animalRepository;

    public AnimalController() {
        this.animalRepository = new AnimalRepository();
    }

    /**
     * Adiciona um novo animal.
     *
     * @param brinco Identificador único da vaca.
     * @param nome   Nome da vaca (opcional).
     * @param raca   Raça da vaca.
     */
    public void adicionarAnimal(String brinco, String nome, String raca) {
        if (brinco == null || brinco.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Brinco' é obrigatório.");
        }

        Vaca novoAnimal = new Vaca(brinco, nome, raca);
        animalRepository.adicionarAnimal(novoAnimal);
    }

    /**
     * Altera os dados de um animal existente.
     *
     * @param brinco Identificador único da vaca.
     * @param nome   Novo nome da vaca.
     * @param raca   Nova raça da vaca.
     */
    public void alterarAnimal(String brinco, String nome, String raca) {
        if (brinco == null || brinco.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Brinco' é obrigatório para alteração.");
        }

        Vaca animalAtualizado = new Vaca(brinco, nome, raca);
        animalRepository.atualizarAnimal(brinco, animalAtualizado);
    }

    /**
     * Exclui um animal com base no brinco.
     *
     * @param brinco Identificador único da vaca.
     */
    public void excluirAnimal(String brinco) {
        if (brinco == null || brinco.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Brinco' é obrigatório para exclusão.");
        }

        animalRepository.excluirAnimal(brinco);
    }

    /**
     * Busca um animal pelo brinco.
     *
     * @param brinco Identificador único da vaca.
     * @return Dados do animal encontrado.
     */
    public Vaca buscarAnimal(String brinco) {
        if (brinco == null || brinco.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'Brinco' é obrigatório para busca.");
        }

        return animalRepository.buscarAnimal(brinco);
    }

    /**
     * Retorna uma lista de todos os animais cadastrados.
     *
     * @return Lista de animais.
     */
    public List<Vaca> listarAnimais() {
        return animalRepository.listarAnimais();
    }
}
