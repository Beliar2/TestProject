package Tests;

import Pages.AddNewComputer;
import Pages.TableComputers;
import inter.Listeners.RetryAnalyzer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import inter.links;

import java.util.concurrent.TimeUnit;

public class ComputerTest implements links{

    WebDriver driver;
    AddNewComputer addNewComputer;
    TableComputers tableComputers;

    @BeforeMethod(groups = {"All", "Regression", "Smoke"})
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get(url);
        driver.get("http://computer-database.gatling.io/computers");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        addNewComputer = new AddNewComputer(driver);
        tableComputers = new TableComputers(driver);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"Smoke"})
    public void AddNewComputer() {
        tableComputers.ClickAddNewComputer();
        addNewComputer.FillComputerName("MacBook");
        addNewComputer.FillIntroduced("2011-03-11");
        addNewComputer.FillDiscontinued("2021-03-11");
        addNewComputer.SelectCompany(1);
        addNewComputer.ClickCreate();
        String text = tableComputers.FirstResult(1, 1);
        Assert.assertEquals(text, "MacBook");
    }


    @AfterMethod(groups = {"All", "Regression", "Smoke"})
    public void Quit() {
        driver.quit();
    }


}
