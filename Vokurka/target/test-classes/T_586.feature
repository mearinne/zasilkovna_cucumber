Feature:

  @Smoker
  Scenario: C2C - Promokód validní - celý proces, https://packeta.atlassian.net/browse/TEST-586

    Then Save a values into context
      | contextName | value                 |
      | myNumber    | 2                     |
      | password    | jsemHeslo             |
      | name        | jouda                 |
      | myTable     | packet_promocode_list |

    Then Write out context value "@password"

    Then Compare two values
      | name      | value     |
      | @name     | jouda     |
      | @password | jsemHeslo |
      | @myNumber | 2         |

    Given Performation of this query and result save to context "@promoCode"
      | Query                                                           |
      | Select code from @myTable where packet_promocode_id = @myNumber |

    Then Write out context value "@promoCode"