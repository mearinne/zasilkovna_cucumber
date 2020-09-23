Feature:

  @Smoker
  Scenario: C2C - Promokód validní - celý proces, https://packeta.atlassian.net/browse/TEST-586

    Given Save a values into context
      | contextName | value            |
      | cardNum     | 4154610001000209 |

    Then Performation of this query and result save to context "myCode"
      | query                                          |
      | select code from packet_promocode where id = 2 |

    Given Open "admin packet dev" page

    Then Wait on the link "C2C v6"

    Then Click on the link "C2C v6"

    Then Click on the link "Create C2C packet"

    Then Wait on the element "promocode"

    Then Fill into input "promocode" your value "@myCode"

    Then Fill into input "street" your value "Nejaka adresa"

    Then Fill into input "city" your value "Nejaka mesto"

    Then Fill into input "zip" your value "19000"

    







