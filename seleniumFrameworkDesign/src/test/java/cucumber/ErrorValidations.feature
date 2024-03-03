
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario: Title of your scenario
    Given I landed on ecommerce page
    When I login with email <email> and password <password>
    Then "Incorrect email or password." message is displayed
    
    
    Examples: 
      | email  				| password 	 | 
      | izi@gmail.com | Testing890 | 
    

