package controllers;

import models.Usuario;
import repositories.UsuarioRepository;

public class LoginController {
    private UsuarioRepository usuarioRepository;

    public LoginController() {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
    }

    public boolean autenticar(String login, String senha) {
        Usuario usuario = usuarioRepository.buscarUsuario(login);
        return usuario != null && usuario.getSenha().equals(senha);
    }

    public void cadastrarUsuario(String login, String nome, String senha) {
        Usuario novoUsuario = new Usuario(login, nome, senha);
        usuarioRepository.adicionarUsuario(novoUsuario);
    }

    public void alterarUsuario(String login, String novoNome, String novaSenha) {
        Usuario usuarioAtualizado = new Usuario(login, novoNome, novaSenha);
        usuarioRepository.atualizarUsuario(login, usuarioAtualizado);
    }

    public void excluirUsuario(String login) {
        usuarioRepository.excluirUsuario(login);
    }
}
