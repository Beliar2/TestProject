package Pages;

import inter.methods.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddNewComputer {

    WebDriver driver;
    Driver web;

    public AddNewComputer(WebDriver driver) {
        this.driver = driver;
        web = new Driver(driver);

    }

    // Add new computer
    private final By Fields = By.xpath("//fieldset//input");

    private final By CompanySelect = By.xpath("//select");

    private final By CreateButton = By.xpath("//input[@value=\"Create this computer\"]");

    public void FillComputerName( String name) {
        List<WebElement> computerName = web.FindElements(Fields);
        computerName.get(0).sendKeys(name);
    }

    public void FillIntroduced(String introduced) {
        List<WebElement> Introduced = web.FindElements(Fields);
        Introduced.get(1).sendKeys(introduced);
    }

    public void FillDiscontinued(String discontinued) {
        List<WebElement> Discontinued = web.FindElements(Fields);
        Discontinued.get(2).sendKeys(discontinued);
    }

    public void SelectCompany(int selected) {
        WebElement element = driver.findElement(CompanySelect);
        Select select = new Select(element);
        select.selectByValue(String.valueOf(selected));
    }

    public void ClickCreate() {
        driver.findElement(CreateButton).click();
    }



}
