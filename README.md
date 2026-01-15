# 🍔 StockLanches - Gestão de Estoque Inteligente

> **Status do Projeto:** Concluído / Em expansão 🚀

O **StockLanches** nasceu de uma necessidade real identificada em uma lanchonete local em Osasco/SP. O estabelecimento utilizava processos manuais (papel e caneta) para o controle de insumos. Este sistema foi desenvolvido para digitalizar essa operação, permitindo um controle de estoque online, rastreável e eficiente.

---

## 📸 Demonstração Visual

Confira abaixo as principais telas do sistema (Autenticação, Gestão de Produtos e Auditoria):


<p align="center">
  <img 
    src="https://raw.githubusercontent.com/LeonVinicius/StockLanches/main/assets/tela_login.png" 
    width="45%" 
  />
  <img 
    src="https://raw.githubusercontent.com/LeonVinicius/StockLanches/main/assets/tela_dashboard.png" 
    width="45%" 
  />
</p>

<p align="center">
  <img 
    src="https://raw.githubusercontent.com/LeonVinicius/StockLanches/main/assets/tela_cadastro.png" 
    width="45%" 
  />
  <img 
    src="https://raw.githubusercontent.com/LeonVinicius/StockLanches/main/assets/tela_historico.png" 
    width="45%" 
  />
</p>
>

---

## 📺 Demonstração em Vídeo

Para ver o sistema em funcionamento e entender o contexto real da solução, assista ao vídeo no LinkedIn:

[![Assista ao vídeo do sistema](https://img.shields.io/badge/LinkedIn-Vídeo%20do%20Projeto-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/feed/update/urn:li:ugcPost:7416573786327715840/)

---

## ✨ Funcionalidades

- **Autenticação:** Login seguro integrado ao banco de dados MySQL.
- **Gestão de Produtos (CRUD):** Cadastro, edição, consulta e exclusão de itens.
- **Monitoramento de Nível Crítico:** Alertas visuais automáticos (Normal, Baixo, Esgotado).
- **Histórico de Movimentações:** Log de auditoria que registra o tipo de ação, produto, quantidade e o usuário responsável.
- **Filtros Avançados:** Busca dinâmica por nome, categoria e ordenação.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework:** Spring Boot 3
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** MySQL 8.0
- **Interface:** Thymeleaf & CSS3

---

## 🎯 Liderança e Desenvolvimento

Embora este projeto faça parte de um trabalho extensionista, assumi a **liderança técnica total**, sendo responsável por:
1. **Modelagem de Dados:** Criação do esquema MySQL e integração via JPA.
2. **Arquitetura MVC:** Separação clara entre Model, Repository, Service e Controller.
3. **Persistência Real:** Migração de dados em memória para banco de dados persistente.
4. **Segurança:** Tratamento de credenciais e variáveis de ambiente.

---

## 🚀 Como executar o projeto

1. **Configuração do Banco:**
   - Crie o banco: `CREATE DATABASE stocklanches;`
   - Configure o `DB_USER` e `DB_PASSWORD` no seu ambiente ou no `application.properties`.

2. **Rodar a aplicação:**
   - Importe como projeto Maven.
   - Execute a classe `DemoApplication.java`.
   - Acesse: `http://localhost:8080`

---

## 👤 Autor

**Leon Vinicius**
- [LinkedIn](https://www.linkedin.com/in/leon-vinicius-398246258/)
- [GitHub](https://github.com/LeonVinicius)

---
*Este projeto transformou um processo analógico em digital, otimizando o tempo e a gestão de um pequeno negócio.*
