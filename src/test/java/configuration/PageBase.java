package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class PageBase {
    protected WebDriver driver;
    private WebDriverWait wait;

    public PageBase(WebDriver driver){
        this.driver = driver;
        this.wait = (WebDriverWait) new WebDriverWait(driver, 600)
                .ignoring(StaleElementReferenceException.class);
    }

    public void waitForElement(By locator){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void click(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
    }

    public void fillString(By locator, String value){
        waitForElement(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public boolean isPresent(By locator){
        try{
            driver.findElement(locator);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
