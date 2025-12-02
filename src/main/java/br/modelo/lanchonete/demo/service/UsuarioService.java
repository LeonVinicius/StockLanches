package br.modelo.lanchonete.demo.service;

import br.modelo.lanchonete.demo.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    // Simulação do Banco de Dados
    private Usuario usuarioCadastrado = new Usuario("Eduardo", "gerente@stocklanches.com", "1234");
    private Usuario usuarioLogado = null;

    public boolean autenticar(String email, String senha) {
        if (email.equals(usuarioCadastrado.getEmail()) && senha.equals(usuarioCadastrado.getSenha())) {
            this.usuarioLogado = usuarioCadastrado;
            return true;
        }
        return false;
    }

    public void cadastrar(Usuario novoUsuario) {
        this.usuarioCadastrado = novoUsuario;
    }

    public void logout() {
        this.usuarioLogado = null;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean isUserLogged() {
        return usuarioLogado != null;
    }
}