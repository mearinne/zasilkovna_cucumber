Feature:

  @Smoker
  Scenario: C2C - Promokód validní - celý proces, https://packeta.atlassian.net/browse/TEST-586

    Given Save a values into context
      | contextName | value            |
      | cardNum     | 4154610001000209 |

    Then Performation of this query and result save to context "myCode"
      | query                                          |
      | select code from packet_promocode where id = 2 |





