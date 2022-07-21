@etsy @regression #this is a tag
Feature: User etsy search
  As a user, when I search for item, I should see the results

  Scenario: User search for wooden spoon
    Given User is on etsy homepage
    Then pagetitle should be as expected
    When user searches for wooden spoon
    Then page title should start with wooden spoon

  Scenario: Users empty search
    Given User is on etsy homepage
    Then pagetitle should be as expected
    When user searches for empty value
    Then All categories should be displayed