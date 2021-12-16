Feature: project implement a kata coffee machine
  
  In this Coffe Machine Project, your task is to implement the logic (starting from a simple class) that translates orders from customers of the coffee machine to the drink maker.
  Your code will use the drink maker protocol to send commands to the drink maker.

  Scenario Outline: the coffee machine receives a commands
    Given The drink maker should receive the correct instructions for my "<command>" order
    When I want to add  "<quantity suggar>" sugar to my order
    And I choose the option extra hot a "<extra hot>"
    And I pay my order with the "<price>"
    Then my order "<command>" has been transferred
    And "<quantity suggar>" of sugar added
    And "<number stick>" of stick added
    And the "<message maker>" is sent to the beverage manufacturer
    And the client receives the message "<message client>"

    Examples: 
      | command      | quantity suggar | number stick | extra hot | price | message maker | message client                                                          |
      | coffee       |               0 |            0 | false     |     1 | C::           | Drink maker makes 1 coffee with no sugar - and therefore no stick       |
      | coffee       |               1 |            1 | false     |     1 | C:1:0         | Drink maker makes 1 coffee with 1 sugar and a stick                     |
      | coffee       |               2 |            1 | false     |     1 | C:2:0         | Drink maker makes 1 coffee with 2 sugar and a stick                     |
      | coffee       |               2 |            1 | false     | 0.2   |               | the coffee order failed it misses: 0,40                                 |
      | coffee       |               2 |            1 | true      |     1 | Ch:2:0        | Drink maker makes 1 extra hot coffee with 2 sugar and a stick           |
      | tea          |               0 |            0 | false     |     1 | T::           | Drink maker makes 1 tea with no sugar - and therefore no stick          |
      | tea          |               1 |            1 | false     |     1 | T:1:0         | Drink maker makes 1 tea with 1 sugar and a stick                        |
      | tea          |               2 |            1 | false     |     1 | T:2:0         | Drink maker makes 1 tea with 2 sugar and a stick                        |
      | tea          |               2 |            1 | false     | 0.3   |               | the tea order failed it misses: 0,10                                    |
      | tea          |               2 |            1 | true      |     1 | Th:2:0        | Drink maker makes 1 extra hot tea with 2 sugar and a stick              |
      | chocolate    |               0 |            0 | false     |     1 | H::           | Drink maker makes 1 chocolate with no sugar - and therefore no stick    |
      | chocolate    |               1 |            1 | false     |     1 | H:1:0         | Drink maker makes 1 chocolate with 1 sugar and a stick                  |
      | chocolate    |               2 |            1 | false     |     1 | H:2:0         | Drink maker makes 1 chocolate with 2 sugar and a stick                  |
      | chocolate    |               2 |            1 | false     | 0.4   |               | the chocolate order failed it misses: 0,10                              |
      | chocolate    |               2 |            1 | true      |     1 | Hh:2:0        | Drink maker makes 1 extra hot chocolate with 2 sugar and a stick        |
      | orange juice |               0 |            0 | false     |     1 | O::           | Drink maker makes 1 orange juice with no sugar - and therefore no stick |
      | orange juice |               0 |            0 | false     | 0.4   |               | the orange juice order failed it misses: 0,20                           |
