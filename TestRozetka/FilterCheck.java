package Exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterCheck extends Page {

    public FilterCheck(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "filter_parameters_form")
    private WebElement filtersList;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[3]/div[1]/div")
    private WebElement product;

    @FindBy(name = "goods_list")
    private WebElement productList;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div[3]/ul/li[3]/p")
    private WebElement resultCount;

    public String getPagesReturned(String filterName){

        filtersList.findElement(By.partialLinkText(filterName)).click();

        String resultMessege;
        int countValid = 0;
        int count = productList.findElements(By.className("g-i-tile-catalog")).size();
        System.out.println(count);
        if (product.getText().contains("Gigabyte")){
            if (resultCount.getText().contains("Подобрано "+count+" товарa из")){
                for (int i = 0; i < count; i++){
                    if (productList.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[" + (i + 3) + "]")).getText().contains("Gigabyte")){
                        countValid++;
                        System.out.println(productList.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div["+ (i + 3) +"]/div[1]/div/div/div/div/a")).getText());
                    } else{
                        System.out.println("Product #"+(i+1)+"not equals filtr");
                    }
                }
                if (countValid == count){
                    resultMessege = "Filter Gigabyte work - test pass";
                } else {
                    resultMessege = "Not all product equals filter";
                }
            } else {
                resultMessege = "Test fail - incorrect count";
            }
        } else {
            resultMessege = "Test fail - filter not work";
        }

        return resultMessege;
    }
}