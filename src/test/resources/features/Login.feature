Feature: Login

  Background: Usuário está na Tela de Login
    Given that the user is login page

  @Login @LoginValid
  Scenario Outline: Realizando Login
    Given that the user fill in the login data with '<email>' and '<password>'
    When to click the enter button
    Then the system directs to the dashboard

    Examples:
      |email                           |password        |
      |plataforma@jacksonteixeira.com  |plataformaJT    |

  @Login @ErrorMessage
  Scenario Outline: Mensagem de erro ao tentar logar
    Given that the user fill in the login data with '<email>' and '<password>'
    When to click the enter button
    Then the system display the message '<errorMessage>'

    Examples:
      |email              |password   | errorMessage              |
      |teste@teste.com    |teste      | Usuário/Senha incorreto!  |

  @Login @MandatoryMessage
  Scenario Outline: Mensagem de campos obrigatórios
    Given that the user does not fill in the required field
    Then the system displays the message '<emailErrorMessage>' and '<passwordErrorMessage>'

    Examples:
      |  emailErrorMessage           | passwordErrorMessage  |
      |  E-mail é obrigatorio!       | Senha é obrigatório! |
