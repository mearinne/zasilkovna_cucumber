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
  "line": 8,
  "name": "Compare two values",
  "rows": [
    {
      "cells": [
        "context name",
        "expected"
      ],
      "line": 9
    },
    {
      "cells": [
        "@vopice",
        "11"
      ],
      "line": 10
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "universalSteps.compareValues(DataTable)"
});
formatter.result({
  "duration": 3733124000,
  "error_message": "java.lang.NullPointerException\r\n\tat step_definitions.universalSteps.compareTwoVals(universalSteps.java:201)\r\n\tat step_definitions.universalSteps.compareValues(universalSteps.java:109)\r\n\tat ✽.Then Compare two values(T_586.feature:8)\r\n",
  "status": "failed"
});
});