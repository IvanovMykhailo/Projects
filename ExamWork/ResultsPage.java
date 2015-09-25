package ExamWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends Page {
 
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    /*@FindBy(className = "sbsb_c")
    private List<WebElement> resultStatMedium;*/
    @FindBy(className = "sbdd_b")
    private WebElement resultStats;

    public String getPagesReturned(){

        long end = System.currentTimeMillis() + 500;
        while (System.currentTimeMillis() < end) {

            if (resultStats.isDisplayed()) {
                break;
            }
        }

        /*for (WebElement suggestion : resultStatMedium) {
            //System.out.println(suggestion.getText());
        }*/

        return resultStats.getText();
    }
}