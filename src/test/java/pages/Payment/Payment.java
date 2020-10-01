package pages.Payment;

import configuration.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

public class Payment extends PageBase {
    private PaymentElements webElements;

    private Payment(WebDriver driver){
        super(driver);
    }

    public static Payment of(WebDriver driver){
        return new Payment(driver);
    }

    //region Web Elements
    private By PaymentOptions() { return By.cssSelector(webElements.PAYMENT_OPTIONS); }
    private By ConfirmOrderButton() { return By.cssSelector(webElements.CONFIRM_ORDER_BUTTON); }
    private By ConfirmationMessage() { return By.cssSelector(webElements.CONFIRMATION_MESSAGE); }
    //endregion

    //region Actions
    public Payment choosePaymentMethod(){
        List<WebElement> options = driver.findElements(PaymentOptions());
        click(options.get(CommonMethods.randomNumber(0, options.size() - 1)));
        return this;
    }
    public Payment clickConfirmOrderButton(){
        click(ConfirmOrderButton());
        return this;
    }
    public Payment validateOrderConfirmation(){
        assertEquals(ConfirmationMessage(), driver.findElement(ConfirmationMessage()).getText(),
                "Your order on My Store is complete.");
        return this;
    }
    //endregion
}
