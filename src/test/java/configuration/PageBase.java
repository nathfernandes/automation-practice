package configuration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.CommonMethods;

import java.util.List;

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

    public void waitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAttributeToBe(WebElement element, String attribute, String expected) {
        wait.until(ExpectedConditions.attributeContains(element, attribute, expected));
    }

    public void click(By locator) {
        waitForElement(locator);
        highlightElement(locator);
        driver.findElement(locator).click();
    }

    public void click(WebElement element){
        waitForElement(element);
        highlightElement(element);
        element.click();
    }

    public void jsClick(By locator){
        WebElement element = driver.findElement(locator);
        highlightElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void fillString(By locator, String value){
        waitForElement(locator);
        highlightElement(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void selectRandOption(By selectLocator, boolean ignoreFirst) {
        int start = ignoreFirst ? 1 : 0;
        WebElement element = driver.findElement(selectLocator);
        highlightElement(element);
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        select.selectByIndex(CommonMethods.randomNumber(start, options.size() - 1));
    }

    public boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public boolean isPresent(By locator){
        try{
            driver.findElement(locator);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        highlightElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void highlightElement(By locator){
        WebElement element = driver.findElement(locator);
        highlightElement(element);
    }

    public void highlightElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void assertEquals(By locator, String actual, String expected){
        WebElement element = driver.findElement(locator);
        try{
            Assert.assertEquals(actual, expected);
        }catch(AssertionError e){
            scrollIntoView(locator);
            highlightElement(element);
            throw e;
        }
    }

    public void assertTrue(By elementToHighlight, boolean condition){
        WebElement element = driver.findElement(elementToHighlight);
        try{
            Assert.assertTrue(condition);
        }catch(AssertionError e){
            scrollIntoView(elementToHighlight);
            highlightElement(element);
            throw e;
        }
    }
}
