
Feature: To Test the Flight Website Functionality
Scenario Outline: To Test the Flight Ticket charge for Two Passengers
Given user launches the  flight WebSite
When  user provides the <Passengers> Information  
And  user Submits the Details
Then user should able to see the Total amount required to pay for Tickets

Examples:
|Passengers|
|1|
