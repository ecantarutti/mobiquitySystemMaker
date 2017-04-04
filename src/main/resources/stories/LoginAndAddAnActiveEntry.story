Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario:  The purpose of this test is to create and to delete a computer.

Given I open the url systemaker.com/angulardemo/
When I click on the 'Login' button
And I enter 'test@test.com' as login email
And I enter 'password' as password
Then I verify that the message 'successively logged in' is displayed on screen

And I click on the 'Add New' button

When I enter 'NewTitle' as title of the new item
And I check the 'Active' checkbox
And I enter 1900 as parent id
And I search for the entry with the title of: 'NewTitle'
Then I verify that the message 'true' is displayed on screen
