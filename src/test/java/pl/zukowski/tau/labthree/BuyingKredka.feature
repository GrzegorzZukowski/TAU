Feature: Buying Kredka
  Customer buys kredka

  Scenario: Customer buys kredka
    Given Customer choses kredka
    When Customer chose colour "czerwony"
    And Customer chose hardness "2H"
    Then Kredka has been sold