package workflows;

import com.aventstack.extentreports.ExtentTest;
import configuration.PageBase;
import org.openqa.selenium.WebDriver;
import pages.Home.Home;
import pages.ProductDetails.ProductDetails;
import utils.CRUD.Product;

public class Workflow extends PageBase {
    private Workflow(WebDriver driver) throws Exception {
        super(driver);
    }

    public static Workflow of(WebDriver driver) throws Exception{
        return new Workflow(driver);
    }

    //region Flow
    public void validateSuccessfulPurchase(){
        Home
                .of(driver)
                .chooseProductItem();

        Product product = ProductDetails
                .of(driver)
                .enterQuantity()
                .chooseSize()
                .chooseColor()
                .saveProductInfo();
    }
    //endregion
}
