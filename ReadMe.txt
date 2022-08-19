
User Stories
-I want to add events to my account.
accomplished by creating a variable holding the customerID and calling that upon visiting the events page.

Admin
-I want to be able to change users names and emails upon request.
accomplished by creating a page locked behind spring security and bcrypt that has full crud capability.

Techical Challenge 
-Adding customer events required the user page to require a currentUser ID, however on startup this was not set so the events page did not work. 
This was resolved by adding null pointer exceptions to several methods using try/catch blocks. 



Link to github project.

https://github.com/SorenKremer/AvailabilityFinder