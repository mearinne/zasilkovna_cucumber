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
        "cardNum",
        "4154610001000209"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Performation of this query and result save to context \"myCode\"",
  "rows": [
    {
      "cells": [
        "query"
      ],
      "line": 11
    },
    {
      "cells": [
        "select code from packet_promocode where id \u003d 2"
      ],
      "line": 12
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Open \"admin packet dev\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Wait on the link \"C2C v6\"",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Click on the link \"C2C v6\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Click on the link \"Create C2C packet\"",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "Wait on the element \"promocode\"",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Fill into input \"promocode\" your value \"@myCode\"",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Fill into input \"street\" your value \"Nejaka adresa\"",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Fill into input \"city\" your value \"Nejaka mesto\"",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "Fill into input \"zip\" your value \"19000\"",
  "keyword": "Then "
});
formatter.match({
  "location": "universalSteps.saveValues(DataTable)"
});
formatter.result({
  "duration": 3695392200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "myCode",
      "offset": 55
    }
  ],
  "location": "universalSteps.saveValToContext(String,DataTable)"
});
formatter.result({
  "duration": 344670300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin packet dev",
      "offset": 6
    }
  ],
  "location": "universalSteps.openPage(String)"
});
formatter.result({
  "duration": 808511500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C2C v6",
      "offset": 18
    }
  ],
  "location": "universalSteps.waitOnLink(String)"
});
formatter.result({
  "duration": 105581200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C2C v6",
      "offset": 19
    }
  ],
  "location": "universalSteps.linkClicked(String)"
});
formatter.result({
  "duration": 60178700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Create C2C packet",
      "offset": 19
    }
  ],
  "location": "universalSteps.linkClicked(String)"
});
formatter.result({
  "duration": 495801700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "promocode",
      "offset": 21
    }
  ],
  "location": "universalSteps.waitOn(String)"
});
formatter.result({
  "duration": 49210200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "promocode",
      "offset": 17
    },
    {
      "val": "@myCode",
      "offset": 40
    }
  ],
  "location": "universalSteps.fillIntoInput(String,String)"
});
formatter.result({
  "duration": 89686300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "street",
      "offset": 17
    },
    {
      "val": "Nejaka adresa",
      "offset": 37
    }
  ],
  "location": "universalSteps.fillIntoInput(String,String)"
});
formatter.result({
  "duration": 78649200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "city",
      "offset": 17
    },
    {
      "val": "Nejaka mesto",
      "offset": 35
    }
  ],
  "location": "universalSteps.fillIntoInput(String,String)"
});
formatter.result({
  "duration": 81596400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zip",
      "offset": 17
    },
    {
      "val": "19000",
      "offset": 34
    }
  ],
  "location": "universalSteps.fillIntoInput(String,String)"
});
formatter.result({
  "duration": 81492600,
  "status": "passed"
});
formatter.uri("justTest.feature");
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
        "cardNum",
        "4154610001000209"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Performation of this query and result save to context \"myCode\"",
  "rows": [
    {
      "cells": [
        "query"
      ],
      "line": 11
    },
    {
      "cells": [
        "select code from packet_promocode where id \u003d 2"
      ],
      "line": 12
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "universalSteps.saveValues(DataTable)"
});
formatter.result({
  "duration": 3074490100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "myCode",
      "offset": 55
    }
  ],
  "location": "universalSteps.saveValToContext(String,DataTable)"
});
formatter.result({
  "duration": 149557800,
  "status": "passed"
});
});