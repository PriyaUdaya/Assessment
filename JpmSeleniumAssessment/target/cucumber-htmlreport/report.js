$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("verifyLogo.feature");
formatter.feature({
  "line": 2,
  "name": "Search for a page and verify logo",
  "description": "",
  "id": "search-for-a-page-and-verify-logo",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@verifyLogo"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Verify the user is able to search a give text",
  "description": "",
  "id": "search-for-a-page-and-verify-logo;verify-the-user-is-able-to-search-a-give-text",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@searchGivenData"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user navigate to application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter given \u003csearchText\u003e and click on Search button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "click on the link",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "verify the logo displayed",
  "keyword": "And "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "search-for-a-page-and-verify-logo;verify-the-user-is-able-to-search-a-give-text;",
  "rows": [
    {
      "cells": [
        "searchText"
      ],
      "line": 12,
      "id": "search-for-a-page-and-verify-logo;verify-the-user-is-able-to-search-a-give-text;;1"
    },
    {
      "cells": [
        "J P Morgan"
      ],
      "line": 13,
      "id": "search-for-a-page-and-verify-logo;verify-the-user-is-able-to-search-a-give-text;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 198688600,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify the user is able to search a give text",
  "description": "",
  "id": "search-for-a-page-and-verify-logo;verify-the-user-is-able-to-search-a-give-text;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@searchGivenData"
    },
    {
      "line": 1,
      "name": "@verifyLogo"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user navigate to application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter given J P Morgan and click on Search button",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "click on the link",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "verify the logo displayed",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSearchStepDefs.navigateToApplication()"
});
formatter.result({
  "duration": 11895595801,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "J P Morgan",
      "offset": 17
    }
  ],
  "location": "GoogleSearchStepDefs.performSearch(String)"
});
formatter.result({
  "duration": 2763581900,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearchStepDefs.clickResult()"
});
formatter.result({
  "duration": 10002551100,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearchStepDefs.verifyLogo()"
});
formatter.result({
  "duration": 102164300,
  "status": "passed"
});
formatter.after({
  "duration": 163283300,
  "status": "passed"
});
});