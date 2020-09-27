package pages.ConfirmationCard;

import configuration.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.CRUD.Cart;
import utils.CRUD.Product;

public class ConfirmationCard extends PageBase {
    private ConfirmationCardElements webElements;

    private ConfirmationCard(WebDriver driver){
        super(driver);
    }

    public static ConfirmationCard of(WebDriver driver){
        return new ConfirmationCard(driver);
    }

    //region Web Elements
    private By ConfirmationMessage() { return By.cssSelector(webElements.CONFIRMATION_MESSAGE); }
    private By NameLabel() { return By.cssSelector(webElements.NAME_LABEL); }
    private By ColorAndSizeLabel() { return By.cssSelector(webElements.COLOR_AND_SIZE_LABEL); }
    private By QuantityLabel() { return By.cssSelector(webElements.QUANTITY_LABEL); }
    private By TotalCurrentPriceLabel() { return By.cssSelector(webElements.TOTAL_CURRENT_PRICE_LABEL); }
    private By ProductImage() { return By.cssSelector(webElements.PRODUCT_IMAGE); }
    private By CartTotalProductsPriceLabel() { return By.cssSelector(webElements.CART_TOTAL_PRODUCTS_PRICE_LABEL); }
    private By ShippingLabel() { return By.cssSelector(webElements.SHIPPING_LABEL); }
    private By CartTotalPriceLabel() { return By.cssSelector(webElements.CART_TOTAL_PRICE_LABEL); }
    private By ProceedToCheckoutButton() { return By.cssSelector(webElements.PROCEED_TO_CHECKOUT_BUTTON); }
    //endregion

    //region Actions
    public ConfirmationCard validateConfirmation(){
        waitForElement(ConfirmationMessage());
        assertEquals(ConfirmationMessage(), driver.findElement(ConfirmationMessage()).getText(),
                "Product successfully added to your shopping cart");
        return this;
    }
    public ConfirmationCard validateProductInformation(Product product){
        String[] colorSize = driver.findElement(ColorAndSizeLabel()).getText().split(", ");

        assertEquals(NameLabel(), driver.findElement(NameLabel()).getText().toUpperCase(),
                product.getName().toUpperCase());
        assertEquals(ColorAndSizeLabel(), colorSize[0], product.getColor());
        assertEquals(ColorAndSizeLabel(), colorSize[1], String.valueOf(product.getSize()));
        assertEquals(QuantityLabel(), driver.findElement(QuantityLabel()).getText(),
                String.valueOf(product.getQuantity()));
        assertEquals(ProductImage(), driver.findElement(ProductImage()).getAttribute("src"),
                product.getImageURL().replace("large", "home"));
        assertEquals(TotalCurrentPriceLabel(), driver.findElement(TotalCurrentPriceLabel()).getText()
                .replace("$", ""), String.format("%.02f", product.getTotalPrice()));

        return this;
    }
    public ConfirmationCard validateCartInformation(Cart cart){
        cart.setShipping(Float.parseFloat(driver.findElement(ShippingLabel()).getText().replace("$",
                "")));
        assertEquals(CartTotalProductsPriceLabel(), driver.findElement(CartTotalProductsPriceLabel()).getText()
                .replace("$", ""), String.format("%.02f", cart.getCartTotal()));
        assertEquals(ShippingLabel(), driver.findElement(ShippingLabel()).getText().replace("$", ""),
                String.format("%.02f", cart.getShipping()));
        assertEquals(CartTotalPriceLabel(), driver.findElement(CartTotalPriceLabel()).getText()
                .replace("$", ""), String.format("%.02f", cart.getCartTotal() + cart.getShipping()));

        return this;
    }
    public ConfirmationCard clickProceedToCheckoutButton(){
        click(ProceedToCheckoutButton());
        return this;
    }
    //endregion
}
