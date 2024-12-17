package repositories;

import models.Vaca;
import db.MongoDBConnection;
import com.mongodb.client.MongoCollection;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class AnimalRepository {
    private final MongoCollection<Vaca> collection;

    public AnimalRepository() {
        collection = MongoDBConnection.getDatabase().getCollection("Vacas", Vaca.class);
    }

    public void adicionarAnimal(Vaca vaca) {
        if (collection.find(eq("brinco", vaca.getBrinco())).first() == null) {
            collection.insertOne(vaca);
        } else {
            throw new IllegalArgumentException("Animal com este brinco já existe!");
        }
    }

    public Vaca buscarAnimal(String brinco) {
        return collection.find(eq("brinco", brinco)).first();
    }

    public void atualizarAnimal(String brinco, Vaca vacaAtualizado) {
        collection.replaceOne(eq("brinco", brinco), vacaAtualizado);
    }

    public void excluirAnimal(String brinco) {
        collection.deleteOne(eq("brinco", brinco));
    }

    public List<Vaca> listarAnimais() {
        return null;
    }
}
