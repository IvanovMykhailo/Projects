Multiply operation

Narrative:
In order to multiply two numbers
As an Google Calculator user
I want to multiply two numbers

GivenStories: stories/pre/precondition.story

Scenario: multiply two numbers using keyboard
Given the user is on the Google Calculator page
When the user inputs 'input' data by keyboard
Then the user got correct 'result'

Examples:
|input     |result|
|100 * 11.1|1110  |
|03 * -7.0 |-21   |
|-100.0 * 0|0     |
|5 * 0,5   |2.5   |
|  * 10    |0     |
|10 *      |Error |
|.001*.0001|1e-7  |