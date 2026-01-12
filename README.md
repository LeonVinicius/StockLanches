# 🍔 StockLanches - Gestão de Estoque Inteligente

> **Status do Projeto:** Concluído / Em expansão 🚀

O **StockLanches** nasceu de uma necessidade real identificada em uma lanchonete local em Osasco/SP. O estabelecimento utilizava processos manuais (papel e caneta) para o controle de insumos. Este sistema foi desenvolvido para digitalizar essa operação, permitindo um controle de estoque online, rastreável e eficiente.

---

## 📸 Demonstração Visual

Confira abaixo as principais telas do sistema (Autenticação, Gestão de Produtos e Auditoria):

![Telas do Sistema](https://private-user-images.githubusercontent.com/147005024/534757723-a2e44f52-a0a5-41f0-b6d4-cf3d7a0da020.PNG?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NjgyNDk2MTEsIm5iZiI6MTc2ODI0OTMxMSwicGF0aCI6Ii8xNDcwMDUwMjQvNTM0NzU3NzIzLWEyZTQ0ZjUyLWEwYTUtNDFmMC1iNmQ0LWNmM2Q3YTBkYTAyMC5QTkc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjYwMTEyJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI2MDExMlQyMDIxNTFaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT04YTA3ODAwNGI2M2E4NWNkMTVlNjYyNjgzYWIxOGRkNmQwN2Y1NDM2ZDgxY2Y4NjRjN2MzYmY0MzA0MDBmZmIxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.PSN4HRKeV-E92efkXOXk9hyloQPIdLrVey4Xwt40Po8)

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
