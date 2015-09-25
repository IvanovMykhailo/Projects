package ExamWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    // Find a single element
    @FindBy(name="q")
    private WebElement googleInputText; //Search box

    public ResultsPage search(String searchStatement){

        googleInputText.sendKeys(searchStatement);

        return PageFactory.initElements(_driver, ResultsPage.class);
    }
}