#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase the order from E-commerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on ecommerce page
	
	@Regression
  Scenario Outline: Positive case of submiting order 
    Given I login with email <email> and password <password>
    Then I added product <productName> to cart
    And Checkout <productName> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | email  				| password 		| productName  |
      | izi@gmail.com | Testing890- | ZARA COAT 3  |
      
      
      
      