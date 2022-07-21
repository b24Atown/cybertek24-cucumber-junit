@cloudtable
  Feature: DDT example with Cloudtables

    Scenario Outline: Adding multiple users to the table
      Given User is on cloudtables homepage
      When User clicks on New button
      When User enters "<firstName>" to firstname field
      And User enters "<lastname>" to lastname field
      And User enters "<position>" to position field
      And User enters "<salary>" to salary field
      And User clicks on create button

      Examples:
        | firstName | lastname | position     | salary |
        | Janina    | R        | SDET         | 115000 |
        | Nisso     | U        | Engineer     | 150000 |
        | Kamila    | S        | Developer    | 130000 |
        | Fahima    | E        | UI Developer | 180000 |