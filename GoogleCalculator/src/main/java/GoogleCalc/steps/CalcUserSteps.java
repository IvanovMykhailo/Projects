package GoogleCalc.steps;

import GoogleCalc.pages.CalculatorPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


/**
 * Created by Mike on 21.10.2015.
 */
public class CalcUserSteps extends ScenarioSteps {
    CalculatorPage calculatorPage;

    @Step
    public void goToCalculator(){
        calculatorPage.open();
        calculatorPage.isPageDone();
    }

    @Step
    public void refreshCalculator() {
        calculatorPage.isCalculatorDone();
    }

    @Step
    public void enterByKeyboard(String input){
        calculatorPage.keyboardInput(input);
    }

    @Step
    public void enterByButton(String symbol) {
        calculatorPage.buttonsInput(symbol);
    }

    @Step
    public void verifyResult(String result) {
        assertEquals(calculatorPage.getResult(),result);
    }
}
