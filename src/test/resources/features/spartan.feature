Feature: Add new spartan

  @spartan
  Scenario: Add new spartan on UI and compare with Confirmation page
    Given User is on spartan  homepage
    When User goges to Web Data page
    And User clicks on add spartan
    And eenters following data:
      | name   | ardit         |
      | gender | Male          |
      | phone  | 2234234234232 |
    Then success message should be displayed
    And data on confirmation page must be the same

    @db
  Scenario: Add new spartan on UI and compare with Oracle Database
    Given User is on spartan  homepage
    When User goges to Web Data page
    And User clicks on add spartan
    And eenters following data:
      | name   | ardit         |
      | gender | Male          |
      | phone  | 2234234234232 |
    Then success message should be displayed
    And data in database must match

