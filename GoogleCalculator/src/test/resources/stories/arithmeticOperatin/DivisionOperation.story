Division operation

Narrative:
In order to division one number to another number
As an Google Calculator user
I want to be able to division one number to another number

GivenStories: stories/pre/precondition.story

Scenario: division one number to another number using keyboard
Given the user is on the Google Calculator page
When the user inputs 'input' data by keyboard
Then the user got correct 'result'

Examples:
|input      |result   |
|333 / 11.1 |30       |
|07 / (-2.0)|-3.5     |
|4 / 0,5    |8        |
|-9.0 / 0   |-Infinity|
|5 / 0      |Infinity |
|0 / 0      |Error    |
|  / 68     |0        |
|10 /       |Error    |
|(2/0)-(2/0)|Error    |