@Test
Feature: CRUD operations on Pet Store API

  @Get
  Scenario: Get available pets
    When user get pets on "status" is "available"
    And verifies the total number pets

  @Post
  Scenario: Post new pet
    When user post new pet
    Then Verify new pet posted

  @Post
  Scenario: Update the pet status to sold
    When the user gets the pet status
    Then the user updates the status from "Available" to "Sold"
    And verifies the status is "Sold"

  @Post
  Scenario: Delete the pet from the store
    Then the user deletes the pet from the store
    And verify pet is removed
