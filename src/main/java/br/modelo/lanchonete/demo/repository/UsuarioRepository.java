package br.modelo.lanchonete.demo.repository;

import br.modelo.lanchonete.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método mágico para buscar usuário pelo nome
    Usuario findByUsuario(String usuario);
}