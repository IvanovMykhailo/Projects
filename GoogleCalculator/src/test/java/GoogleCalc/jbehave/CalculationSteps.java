package GoogleCalc.jbehave;

import GoogleCalc.steps.CalcUserSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;

/**
 * Created by Mike on 21.10.2015.
 */
public class CalculationSteps {

    @Steps
    CalcUserSteps userSteps;

    @Given ("precondition")
    public void precondition() { userSteps.goToCalculator(); }

    @Given("the user is on the Google Calculator page")
    public void givenTheUserIsOnTheGoogleCalculatorpage() {
        userSteps.refreshCalculator();
    }

    @When("the user inputs '$input' data by keyboard")
    public void whenTheUserInputsByKeyboard(String input){
        userSteps.enterByKeyboard(input);
    }

    @When("the user inputs '$symbol' data by button bar")
    public void whenTheUserInputsByButtonBar(String symbol){
        userSteps.enterByButton(symbol);
    }

    @Then("the user got correct '$result'")
    public void thenTheUserGotCorrectResult(String result){
        userSteps.verifyResult(result);
    }
}
