package Exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class ResultsPage extends Page {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[3]/div[1]/div")
    private WebElement product;

    @FindBy(name = "goods_list")
    private WebElement productList;

    @FindBy(name = "more_goods")
    private WebElement moreProducts;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div[3]/ul/li[3]/p")
    private WebElement resultCount;

    public String getPagesReturned(String filterName){

        String resultMessege;
        int countValid = 0;

        /*while (productList.findElement(By.name("more_goods")).isEnabled()){
            moreProducts.click();
        }*/

        int count = productList.findElements(By.className("g-i-tile-catalog")).size();
        System.out.println(count);
        if (product.getText().contains(filterName)){
            if (resultCount.getText().contains("Подобрано "+count+" товарa из")){
                for (int i = 0; i < count; i++){
                    if (productList.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[" + (i + 3) + "]")).getText().contains(filterName)){
                        countValid++;
                        System.out.println(productList.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div["+ (i + 3) +"]/div[1]/div/div/div/div/a")).getText());
                    } else{
                        System.out.println("Product #"+(i+1)+"not match filter");
                    }
                }
                if (countValid == count){
                    resultMessege = "Filter "+filterName+" work - test pass";
                } else {
                    resultMessege = "Not all product match filter";
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