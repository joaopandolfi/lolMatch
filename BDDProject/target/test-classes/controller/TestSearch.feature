Feature: Testes da Busca
  Passa nois Paulim

  Scenario Outline: Busca por nome
    Given escrevo o nome do usuario <usuario>
    When clico em "pesquisar"
    Then o IdInGame vai ser <idIngame>
  Examples:
    | usuario | idIngame |
    | "seu madruga" | "404536" |
    | "gasbrela" | "465116" |