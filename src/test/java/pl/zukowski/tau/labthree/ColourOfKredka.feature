Feature: Is it czerwony?
  Customer want to know the colour of kredka

  Scenario Outline: Is it czerwony or not
    Given This is "<kolor>"
    When Are you sure its czerwony
    Then I should be told "<answer>"

    Examples:
      | kolor     | answer  |
      | czerwony  | Tak     |
      | niebieski | Nie     |
      | zielony   | Nie     |