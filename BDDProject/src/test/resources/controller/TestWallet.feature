Feature: Teste do controlador da carteira

  Scenario: Teste de remocao de valores
    Given eu tenho 100 na carteira
    When retiro 50
    Then fico com 50

  Scenario Outline: Teste de remocao de valores usando tabela
    Given eu tenho <entrada> na carteira
    When retiro <retirada>
    Then fico com <saldo>
   Examples:
    | entrada | retirada | saldo |
    | 200 | 30 | 170 |
    | 100 | 2 | 98 |

  Scenario Outline: Teste de deposito e saque da carteira
    Given eu tenho <entrada> na carteira
    When deposito <deposito>
    And retiro <retirada>
    Then fico com <saldo>
    Examples:
      | entrada | deposito | retirada | saldo |
      | 200     | 30       | 60       | 170 |
      | 100     | 2        | 98       | 4   |
