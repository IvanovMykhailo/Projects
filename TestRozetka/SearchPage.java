package Exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Find a single element
    @FindBy(id = "filter_parameters_form")
    private WebElement filtersList;

    public ResultsPage search(String filterName){

        filtersList.findElement(By.partialLinkText(filterName)).click();

        return PageFactory.initElements(_driver, ResultsPage.class);
    }
}