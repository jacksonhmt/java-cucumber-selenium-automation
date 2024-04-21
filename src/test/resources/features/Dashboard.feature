
Feature: Painel Inicial

  Background: Realizando Login
    Given that the user fill in the login data with "plataforma@jacksonteixeira.com" and "plataformaJT"
    When to click the enter button
    Then the system directs to the dashboard

  @Dashboard @ViewProductButtonOnDashBoard
  Scenario: Visualizando produtos atraves do painel inicial do sistema
    Given that the user is on the dashboard
    When click the button Visualizar Produto
    Then the system directs to the product pages