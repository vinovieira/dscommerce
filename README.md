# DSCommerce
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE)

# Sobre o projeto

O projeto é uma API REST para um sistema de e-commerce que permite gerenciar usuários, produtos e categorias. Ele fornece os endpoints necessários para operações como apresentar um catálogo de produtos filtrável por nome, onde os usuários podem visualizar detalhes e adicionar itens a um carrinho de compras. A API permite gerenciar o carrinho (incluir, remover ou alterar quantidades) e registrar pedidos, que são salvos com status inicial "aguardando pagamento". Os pedidos podem mudar de status (pago, enviado, entregue, cancelado), e o instante de pagamento é registrado.

## Casos de Uso do Sistema (visão geral)

O escopo funcional do sistema consiste nos seguintes casos de uso:

| Caso de uso           | Visão geral                                                                 | Acesso         |
|-----------------------|-----------------------------------------------------------------------------|---------------|
| Manter produtos       | CRUD de produtos, podendo filtrar itens pelo nome                          | Somente Admin |
| Manter categorias     | CRUD de categorias, podendo filtrar itens pelo nome                        | Somente Admin |
| Manter usuários       | CRUD de usuários, podendo filtrar itens pelo nome                          | Somente Admin |
| Consultar catálogo    | Listar produtos disponíveis, podendo filtrar produtos pelo nome            | Público        |
| Login                 | Efetuar login no sistema                                                   | Público        |
| Registrar pedido      | Salvar no sistema um pedido a partir dos dados do carrinho de compras informado | Usuário logado |
| Atualizar perfil      | Atualizar o próprio cadastro                                               | Usuário logado |
| Visualizar pedidos    | Visualizar os pedidos que o próprio usuário já fez                         | Usuário logado |
| Registrar pagamento   | Salvar no sistema os dados do pagamento de um pedido                      | Somente Admin  |
| Reportar pedidos      | Relatório de pedidos, podendo ser filtrados por data                      | Somente Admin  |

## Modelo conceitual
![Modelo Conceitual](https://github.com/user-attachments/assets/40403600-8bcd-48cd-9362-3c620fd6f125)

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Banco de dados H2
- Banco de dados PostgreSQL
- Java Bean Validation
- Autenticação e Autorização (Spring Security, OAuth2 com JWT)
- Postman para testes de integração
- Tratamento de exceções: Mensagens de erro específicas e respeitando Códigos Http
- Consultas ao Banco de Dados: utilizando boas práticas para evitar consultas repetitivas (Queries N+1).

# Como executar o projeto

## Back end
Pré-requisitos: Java 22

```bash
# clonar repositório
git clone https://github.com/vinovieira/dscommerce

# entrar na pasta do projeto
cd dscommerce

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Silvino Vieira Junior

https://www.linkedin.com/in/vinovieira
