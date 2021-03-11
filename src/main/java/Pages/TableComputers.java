package Pages;

import inter.methods.Driver;
import inter.methods.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableComputers {

    WebDriver driver;
    Driver web;


    public TableComputers(WebDriver driver) {
        this.driver = driver;
        web = new Driver(driver);

    }

    //Table
    private final By TableComputers = By.xpath("//table[@class=\"computers zebra-striped\"]");

    private final By AddNewButton = By.xpath("//a[@class=\"btn success\"]");



    // Table
    public String FirstResult(int row, int column) {
        WebElement table = web.FindElement(TableComputers);
        inter.methods.Table tableComputers = new Table(table, driver);
        return tableComputers.getValue(row, column);
    }

    // Buttons
    public void ClickAddNewComputer() {
        web.FindElement(AddNewButton).click();
    }



}
