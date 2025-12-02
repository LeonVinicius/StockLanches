package br.modelo.lanchonete.demo.repository;

import br.modelo.lanchonete.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // O JpaRepository já nos dá: save, delete, findAll, findById...
}