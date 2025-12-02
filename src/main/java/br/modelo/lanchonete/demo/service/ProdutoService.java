package br.modelo.lanchonete.demo.service;

import br.modelo.lanchonete.demo.model.Produto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProdutoService {
    private List<Produto> listaDeProdutos = new ArrayList<>();

    public List<Produto> listarTodos() {
        return listaDeProdutos;
    }

    public void adicionar(Produto produto) {
        produto.setId((long) (listaDeProdutos.size() + 1));
        listaDeProdutos.add(produto);
    }

    public void atualizar(Produto produtoEditado) {
        for (int i = 0; i < listaDeProdutos.size(); i++) {
            Produto p = listaDeProdutos.get(i);
            if (p.getId() != null && produtoEditado.getId() != null && p.getId().equals(produtoEditado.getId())) {
                // Atualiza os campos
                p.setNome(produtoEditado.getNome());
                p.setCategoria(produtoEditado.getCategoria());
                p.setQuantidade(produtoEditado.getQuantidade());
                p.setPrecoCusto(produtoEditado.getPrecoCusto());
                p.setPrecoVenda(produtoEditado.getPrecoVenda());
                p.setDescricao(produtoEditado.getDescricao());
                p.setEstoqueMinimo(produtoEditado.getEstoqueMinimo());
                p.setFornecedor(produtoEditado.getFornecedor());
                p.atualizarStatus();
                listaDeProdutos.set(i, p);
                break;
            }
        }
    }

    public Produto buscarPorId(Long id) {
        return listaDeProdutos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Produto buscarPrimeiroPorNome(String nome) {
        return listaDeProdutos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .findFirst()
                .orElse(null);
    }
    
    public List<Produto> filtrar(String busca, String categoria, String ordenar) {
        Stream<Produto> stream = listaDeProdutos.stream();

        if (busca != null && !busca.isEmpty()) {
            stream = stream.filter(p -> p.getNome().toLowerCase().contains(busca.toLowerCase()));
        }

        if (categoria != null && !categoria.isEmpty() && !categoria.equals("Todas")) {
            stream = stream.filter(p -> p.getCategoria().equalsIgnoreCase(categoria));
        }

        if (ordenar != null) {
            switch (ordenar) {
                case "menor_preco": stream = stream.sorted(Comparator.comparing(Produto::getPrecoVenda)); break;
                case "maior_preco": stream = stream.sorted(Comparator.comparing(Produto::getPrecoVenda).reversed()); break;
                case "quantidade_baixa": stream = stream.sorted(Comparator.comparing(Produto::getQuantidade)); break;
                case "nome_za": stream = stream.sorted(Comparator.comparing(Produto::getNome).reversed()); break;
                default: stream = stream.sorted(Comparator.comparing(Produto::getNome)); break;
            }
        } else {
             stream = stream.sorted(Comparator.comparing(Produto::getId));
        }
        return stream.collect(Collectors.toList());
    }

    public void remover(Long id) {
        Produto p = buscarPorId(id);
        if (p != null) listaDeProdutos.remove(p);
    }
}