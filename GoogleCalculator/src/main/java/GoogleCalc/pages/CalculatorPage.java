package GoogleCalc.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Mike on 20.10.2015.
 */
@DefaultUrl("https://www.google.com/")
public class CalculatorPage extends PageObject {

    @FindBy(id="lst-ib")
    private WebElementFacade searchField;

    @FindBy(id="cwotbl")
    private WebElementFacade calcField;

    @FindBy(id="cwbt06")
    private WebElementFacade clearButton;

    @FindBy(css=".cwcd.cwbbc")
    private WebElementFacade simpleCalculatorButtons;

    public void isPageDone() {
        searchField.clear();
        searchField.sendKeys("1-1", Keys.ENTER);
        waitFor(ExpectedConditions.visibilityOf(calcField));
    }

    public void isCalculatorDone(){
        clearButton.click();
    }

    public void keyboardInput(String input) {
        Actions enterByKeyboard = new Actions(getDriver());
        enterByKeyboard.sendKeys(calcField, input.replaceAll("\\s", ""), Keys.ENTER).perform();
    }

    public void pressButton(String symbol){
        List<WebElement> buttons = simpleCalculatorButtons.findElements(By.cssSelector("div>div>div>span"));
        for (WebElement b: buttons){
            if (b.getText().equals(symbol)) {
                b.click();
            }
        }
    }

    public void buttonsInput(String input){
        char[]expression = input.toCharArray();
        for (char s: expression){
            pressButton(Character.toString(s));
        }
    }

    public String getResult(){
        return calcField.getText();
    }
}

