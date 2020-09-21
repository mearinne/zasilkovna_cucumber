$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("T_586.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "",
  "id": "",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "C2C - Promokód validní - celý proces, https://packeta.atlassian.net/browse/TEST-586",
  "description": "",
  "id": ";c2c---promokód-validní---celý-proces,-https://packeta.atlassian.net/browse/test-586",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Smoker"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Save a values into context",
  "rows": [
    {
      "cells": [
        "contextName",
        "value"
      ],
      "line": 7
    },
    {
      "cells": [
        "myNumber",
        "2"
      ],
      "line": 8
    },
    {
      "cells": [
        "password",
        "jsemHeslo"
      ],
      "line": 9
    },
    {
      "cells": [
        "name",
        "jouda"
      ],
      "line": 10
    },
    {
      "cells": [
        "myTable",
        "packet_promocode_list"
      ],
      "line": 11
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Write out context value \"@password\"",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Compare two values",
  "rows": [
    {
      "cells": [
        "name",
        "value"
      ],
      "line": 16
    },
    {
      "cells": [
        "@name",
        "jouda"
      ],
      "line": 17
    },
    {
      "cells": [
        "@password",
        "jsemHeslo"
      ],
      "line": 18
    },
    {
      "cells": [
        "@myNumber",
        "2"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Performation of this query and result save to context \"@promoCode\"",
  "rows": [
    {
      "cells": [
        "Query"
      ],
      "line": 22
    },
    {
      "cells": [
        "Select code from @myTable where packet_promocode_id \u003d @myNumber"
      ],
      "line": 23
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "Write out context value \"@promoCode\"",
  "keyword": "Then "
});
formatter.match({
  "location": "universalSteps.saveValues(DataTable)"
});
formatter.result({
  "duration": 3744785200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "@password",
      "offset": 25
    }
  ],
  "location": "universalSteps.writeOut(String)"
});
formatter.result({
  "duration": 469800,
  "status": "passed"
});
formatter.match({
  "location": "universalSteps.compareValues(DataTable)"
});
formatter.result({
  "duration": 307500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "@promoCode",
      "offset": 55
    }
  ],
  "location": "universalSteps.saveValToContext(String,DataTable)"
});
formatter.result({
  "duration": 316874500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "@promoCode",
      "offset": 25
    }
  ],
  "location": "universalSteps.writeOut(String)"
});
formatter.result({
  "duration": 1271300,
  "status": "passed"
});
});