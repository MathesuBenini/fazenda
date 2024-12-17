package repositories;

import models.Usuario;
import db.MongoDBConnection;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

public class UsuarioRepository {
    private final MongoCollection<Usuario> collection;

    public UsuarioRepository() {
        collection = MongoDBConnection.getDatabase().getCollection("usuarios", Usuario.class);
    }

    public void adicionarUsuario(Usuario usuario) {
        if (collection.find(eq("login", usuario.getLogin())).first() == null) {
            collection.insertOne(usuario);
        } else {
            throw new IllegalArgumentException("Login já existe!");
        }
    }

    public Usuario buscarUsuario(String login) {
        return collection.find(eq("login", login)).first();
    }

    public void atualizarUsuario(String login, Usuario usuarioAtualizado) {
        collection.replaceOne(eq("login", login), usuarioAtualizado);
    }

    public void excluirUsuario(String login) {
        collection.deleteOne(eq("login", login));
    }
}
