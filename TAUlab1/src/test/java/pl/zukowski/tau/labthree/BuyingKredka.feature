Feature: BuyingKredka
  Customer buys kredka

Scenario: Customer buys kredka
  Given Customer choses kredka
  When Customer choses colour "zielony"
  And Customer choses hardness "2B"
  Then Kredka has been sold