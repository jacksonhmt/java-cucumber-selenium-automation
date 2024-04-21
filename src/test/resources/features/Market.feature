Feature: Mercado

  Background: Realizando o login e entrando na tela de Dashboard
    Given that the user fill in the login data with "plataforma@jacksonteixeira.com" and "plataformaJT"
    When to click the enter button
    Then the system directs to the dashboard

  @Market @AccessingTheMarketsPage
  Scenario: Sistema direciona para a tela de login
    Given that the user is on the dashboard
    When to click on the Market Option
    Then the system directs you to the market pages

  @Market @CheckProductSearch
  Scenario Outline: Verificando o produto pesquisado
    Given that the user is on the dashboard
    When to click on the Market Option
    And the user to fill in the search field with '<product>'
    Then the system displays the searched '<product>'

    Examples:
      | product               |
      | Monitor 18 Polegadas  |
      | Teclado               |
      | Monitor 24 polegadas |