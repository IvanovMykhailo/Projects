Check button

Narrative:
In order to click button
As an Google Calculator user
I want to see correct symbol into input field

GivenStories: stories/pre/precondition.story

Scenario: input symbol using button bar

Given the user is on the Google Calculator page
When the user inputs 'symbol' data by button bar
Then the user got correct 'result'

Examples:
|symbol|result|
|.     |.     |
|+     |0 +   |
|−     |0 -   |
|×     |0 ×   |
|÷     |0 ÷   |
|%     |0%    |
|=     |0     |
|1     |1     |
|2     |2     |
|3     |3     |
|4     |4     |
|5     |5     |
|6     |6     |
|7     |7     |
|8     |8     |
|9     |9     |
|(0)   |(0)   |

