package br.modelo.lanchonete.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    private Integer quantidade;
    private Double precoCusto;
    private Double precoVenda;
    private String descricao;
    private Integer estoqueMinimo;
    private String fornecedor;
    private String status; 

   
    public Produto() {}

    public Produto(String nome, String categoria, Integer quantidade, Double precoCusto, Double precoVenda, String descricao, Integer estoqueMinimo, String fornecedor) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.descricao = descricao;
        this.estoqueMinimo = estoqueMinimo;
        this.fornecedor = fornecedor;
        this.atualizarStatus(); 
    }

 
    public void atualizarStatus() {
        if (this.quantidade == 0) {
            this.status = "Esgotado";
        } else if (this.estoqueMinimo != null && this.quantidade <= this.estoqueMinimo) {
            this.status = "Baixo";
        } else {
            this.status = "Normal";
        }
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Double getPrecoCusto() { return precoCusto; }
    public void setPrecoCusto(Double precoCusto) { this.precoCusto = precoCusto; }

    public Double getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(Double precoVenda) { this.precoVenda = precoVenda; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getEstoqueMinimo() { return estoqueMinimo; }
    public void setEstoqueMinimo(Integer estoqueMinimo) { this.estoqueMinimo = estoqueMinimo; }

    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}