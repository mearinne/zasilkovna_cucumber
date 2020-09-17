$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("browserTest.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "",
  "id": "",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Editing the profile",
  "description": "",
  "id": ";editing-the-profile",
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
  "line": 5,
  "name": "Open browser Chrome",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Write out this word \"pepik\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps_browser.openning()"
});
formatter.result({
  "duration": 5010613701,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "pepik",
      "offset": 21
    }
  ],
  "location": "steps_browser.writeOut(String)"
});
formatter.result({
  "duration": 2140901,
  "status": "passed"
});
});