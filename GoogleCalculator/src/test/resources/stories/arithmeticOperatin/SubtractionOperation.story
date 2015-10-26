Subtraction operation

Narrative:
In order to subtract first number from second number
As an Google Calculator user
I want to be able to subtract one number from another number

GivenStories: stories/pre/precondition.story

Scenario: subtract one number from another number using keyboard
Given the user is on the Google Calculator page
When the user inputs 'input' data by keyboard
Then the user got correct 'result'

Examples:
|input     |result|
|100 - 11.2|88.8  |
|03 -(-7.0)|10    |
|-9.0 - 0  |-9    |
|4 - 0,5   |3.5   |
|  - 68    |-68   |
|10 -      |Error |