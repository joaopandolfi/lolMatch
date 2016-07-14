Feature: Testes dos controlers
  Esse teste é para passar na matéria de LES

  Scenario: Login no lolmatch
    Given meu login e "t@1.com" e minha senha e "123"
    When eu realizar "logar"
    Then meu IdInGame vai ser "2320936"
