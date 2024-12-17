package repositories;

import models.Producao;
import db.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import models.Producao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class ProducaoRepository {
    private final MongoCollection<Producao> collection;

    public ProducaoRepository() {
        collection = MongoDBConnection.getDatabase().getCollection("producoes", Producao.class);
    }

    public void registrarProducao(Producao producao) {
        collection.insertOne(producao);
    }

    public List<Producao> listarProducaoDiaria(LocalDate data) {
        return collection.find(eq("data", data)).into(new ArrayList<>());
    }

    public List<Producao> listarProducaoMensal(int mes, int ano) {
        return collection.find(and(
                eq("data.ano", ano),
                eq("data.mes", mes)
        )).into(new ArrayList<>());
    }

    public List<Producao> listarProducaoPorAnimal(String brinco, int mes, int ano) {
        return collection.find(and(
                eq("brinco", brinco),
                eq("data.ano", ano),
                eq("data.mes", mes)
        )).into(new ArrayList<>());
    }
}
