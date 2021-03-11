package inter.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private WebDriver driver;
    private WebElement element;

    public Table(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }


    public List<WebElement> getRows() {
        List<WebElement> rows = element.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

    public List<List<WebElement>> getRowsAndColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsAndColumns = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> rowAndColumn = row.findElements(By.xpath(".//td"));
            rowsAndColumns.add(rowAndColumn);
        }
        return rowsAndColumns;
    }


    public String getValue(int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsAndColumns = getRowsAndColumns();
        WebElement cell = rowsAndColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }


}
