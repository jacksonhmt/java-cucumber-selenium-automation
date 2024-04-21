Feature: Produto

  Background: Realizando o Login
    Given that the user fill in the login data with "plataforma@jacksonteixeira.com" and "plataformaJT"
    When to click the enter button
    Then the system directs to the dashboard

  @Product @AccessingTheProductPage
  Scenario: Acessando a Página de Produtos
    Given that the user is on the dashboard
    When click on the Product Option
    Then the system directs to the product page

  @Product @RegisteringNewProduct
  Scenario Outline: Cadastrando Produtos
    Given that the user is on the product search page
    When to click on the new product button
    And fill form with '<nomeDoProduto>', '<quantidade>', '<precoDeCompra>', '<precoDeVenda>', '<tipoDeProduto>', '<descricao>'

    Examples:
      | nomeDoProduto | quantidade  | precoDeCompra | precoDeVenda | tipoDeProduto | descricao                  |
      | iphone 5s     | 5           | 400,00        | 540,00    | Celular     | Descrição do Primeiro Teste. |
      | iphone XR     | 2           | 1.400,00      | 1.900,00  | Celular     | Descrição do Segundo Teste.  |
      | iphone 14     | 3           | 5.900,90      | 6.550,00  | Celular     | Descrição do Terceiro Teste. |
      | iphone 13     | 4           | 4.900,90      | 5.550,00  | Celular     | Descrição do Quarto Teste.   |
      | iphone 12     | 5           | 3.900,90      | 4.550,00  | Celular     | Descrição do Quinto Teste.   |