Addition operation

Narrative:
In order to add two numbers
As an Google Calculator user
I want to add two numbers

GivenStories: stories/pre/precondition.story

Scenario: addition two numbers using keyboard
Given the user is on the Google Calculator page
When the user inputs 'input' data by keyboard
Then the user got correct 'result'

Examples:
|input     |result|
|100 + 11.1|111.1 |
|03 + -7.0 |-4    |
|-100.0 + 0|-100  |
|5 + 0,5   |5.5   |
|  + 10    |10    |
|10+       |Error |
|10+50%    |15    |