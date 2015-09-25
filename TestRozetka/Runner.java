package Exam;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        String testDataFile = "D:\\exdata.txt";
        String errorsFile = "D:\\errors.txt";
        String baseUrl = "http://rozetka.com.ua/notebooks/c80004/filter/";
        String myFilter = "Apple";

        ArrayList<String> listFilters = new ArrayList<String>();
        try  { //Формирование и запись результатов
            listFilters = registrationTestData(testDataFile);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        //System.out.println(listFilters);
        //System.out.println(listFilters.size());

        WebDriver driver = new FirefoxDriver();

        //Проверка фильтра Gigabyte (Page Object)
        driver.get(baseUrl);
        SearchPage googleHome = PageFactory.initElements(driver, SearchPage.class);
        ResultsPage searchResults = googleHome.search(myFilter);
        String result = searchResults.getPagesReturned(myFilter);
        System.out.println(result);
        try  {
            writeErrorsToFile(errorsFile, result);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        //FilterCheck filterPage = PageFactory.initElements(driver, FilterCheck.class);
        //filterPage.getPagesReturned("Apple");

        //Проверка фильтра цены
        driver.get(baseUrl);
        driver.findElement(By.id("price[min]")).clear();
        driver.findElement(By.id("price[min]")).sendKeys("5000");
        String priceMax = driver.findElement(By.id("price[max]")).getText();
        driver.findElement(By.id("submitprice")).click();
        String price = driver.findElement(By.className("filter-active-l")).getText();
        if (price.contains("от 5000 до "+priceMax )){
            System.out.println("Price filter work");
        } else {
            System.out.println("Price filter not work");
        }

        //Проверка всех фильтров-чекбоксов
        for (int i = 0; i < listFilters.size(); i++){
            String nameFilter = listFilters.get(i);
            if (nameFilter.startsWith("!")){
                System.out.println("--->Field name" + nameFilter + "checking...<---");
                try  { //Формирование и запись результатов
                    writeErrorsToFile(errorsFile, "--->Field name _" + nameFilter + "_ checking...<---");
                } catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            } else {
                driver.get(baseUrl);
                //Thread.sleep(5000);
                try {
                    driver.findElement(By.id("filter_parameters_form")).findElement(By.partialLinkText(nameFilter)).click();
                    String ttt = driver.findElement(By.className("filter-active-l")).getText();
                    if (ttt.contains(nameFilter)){
                        System.out.println("Filter " + nameFilter + " - work");
                        try  { //Формирование и запись результатов
                            writeErrorsToFile(errorsFile, "Filter " + nameFilter + " - work");
                        } catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Filter " + nameFilter + " - not work");
                        try  { //Формирование и запись результатов
                            writeErrorsToFile(errorsFile, "Filter " + nameFilter + " - not work");
                        } catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                catch (NoSuchElementException e){
                    e.printStackTrace();
                    System.out.println("Filter " + nameFilter + " not found");
                    try  { //Формирование и запись результатов
                        writeErrorsToFile(errorsFile, "Filter " + nameFilter + " not found");
                    } catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        try  { //Формирование и запись результатов
            writeErrorsToFile(errorsFile, "\r\n");
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        driver.close();

    }

    public static ArrayList<String> registrationTestData(String testDataLocation) throws IOException {

        int lineCount = 0;
        String line;
        String words;
        ArrayList<String> filtersList = new ArrayList<String>();

        //read from file test data
        File file = new File(testDataLocation);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));

        while ((line = br.readLine()) != null) {
            //lineCount ++;
            words = line;
            filtersList.add(words);
            lineCount = lineCount + 1;
        }
        return filtersList;
    }

    public static void writeErrorsToFile(String errorsFileName, String newError) throws IOException {  // запись массива в файл

        BufferedWriter out = new BufferedWriter(new FileWriter(errorsFileName, true));
        out.write(newError);
        out.newLine();
        out.close();
    }
}