package workflows;

import configuration.PageBase;
import org.openqa.selenium.WebDriver;
import pages.CartSummary.CartSummary;
import pages.ConfirmationCard.ConfirmationCard;
import pages.Home.Home;
import pages.ProductDetails.ProductDetails;
import pages.SignIn.SignIn;
import utils.CRUD.Cart;
import utils.CRUD.User;

public class Workflow extends PageBase {
    private Cart cart;

    private Workflow(WebDriver driver) {
        super(driver);
    }

    public static Workflow of(WebDriver driver) {
        return new Workflow(driver);
    }

    //region Flow
    public Workflow validateProductAdded(){
        Home
                .of(driver)
                .chooseProductItem();
        cart = ProductDetails
                .of(driver)
                .enterQuantity()
                .chooseSize()
                .chooseColor()
                .saveProductInfo()
                .addToCart()
                .cart;
        ConfirmationCard
                .of(driver)
                .validateConfirmation()
                .validateProductInformation(cart.getProducts().get(cart.getProducts().size() - 1))
                .validateCartInformation(cart)
                .clickProceedToCheckoutButton();
        return this;
    }
    public Workflow validateSuccessfulPurchase(User user){
        CartSummary
                .of(driver)
                .validateProductInformation(cart)
                .validateCartInformation(cart)
                .clickProceedToCheckoutButton();
        SignIn
                .of(driver)
                .fillEmailInput(user)
                .clickCreateAnAccountButton()
                .fillCreateAccountForm(user)
                .clickRegisterButton();
        return this;
    }
    //endregion
}
