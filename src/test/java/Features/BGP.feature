Feature: Business Grants Portal
  As a public user
  In order to apply for a new grant
  I need to check my eligibility on the Business Grants Portal

  Scenario: Check Eligibility on BGP
    Given I navigate to BGP
      Then I am on the BGP portal

    When I click on login
    And I login as a BGP user
      Then I am logged in to the portal

    When I click on Get new grant
      Then I should be able to select the sector

    When I select the sector
      Then I should be asked for my purpose of applying the grant

    When I select my purpose for applying the grant
      Then I should be asked for the area to develop with the grant

    When I select the area to develop with the grant
      Then I should be able to apply for the grant

    When I am on Grant Actions page
      Then I should be able to proceed with my application

    When I am on Check my Eligibility page
      Then I should see different behaviour based on my answer to the eligibility criteria