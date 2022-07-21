Feature: Data driven testing using Scenario outline with examples table

  Scenario Outline: Google capital cities search
    Given User is on Google home page
    When User searches for "<country>" capital
    Then User should see "<capital>" in the results
    Examples:
      | country      | capital         |
      | USA          | Washington, DC. |
      | Turkey       | Ankara          |
      | Ukraine      | Kyiv            |
      | Turkmenistan | Ashgabat        |
      | Latvia       | Riga            |
      | Uzbekistan   | Tashkent        |
      | Eritrea      | Asmara          |