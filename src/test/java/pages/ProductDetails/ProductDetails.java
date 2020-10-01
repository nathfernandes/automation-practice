package pages.ProductDetails;

import configuration.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CRUD.Cart;
import utils.CRUD.Product;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails extends PageBase {
    private ProductDetailsElements webElements;
    private Product product;
    public static Cart cart;

    private ProductDetails(WebDriver driver){
        super(driver);
    }

    public static ProductDetails of(WebDriver driver){
        return new ProductDetails(driver);
    }

    //region Web Elements
    private By NameLabel() { return By.cssSelector(webElements.NAME_LABEL); }
    private By SkuLabel() { return By.cssSelector(webElements.SKU_LABEL); }
    private By CurrentPriceLabel() { return By.cssSelector(webElements.CURRENT_PRICE_LABEL); }
    private By ReductionLabel() { return By.cssSelector(webElements.REDUCTION_LABEL); }
    private By OldPriceLabel() { return By.cssSelector(webElements.OLD_PRICE_LABEL); }
    private By QuantityInput() { return By.cssSelector(webElements.QUANTITY_INPUT); }
    private By SizeCombo() { return By.cssSelector(webElements.SIZE_COMBO); }
    private By SelectedSize() { return By.cssSelector(webElements.SELECTED_SIZE); }
    private By ColorList() { return By.cssSelector(webElements.COLOR_LIST); }
    private By ColorOptions() { return By.cssSelector(webElements.COLOR_OPTIONS); }
    private By ColorPicked() { return By.cssSelector(webElements.COLOR_PICKED); }
    private By ProductImage() { return By.cssSelector(webElements.PRODUCT_IMAGE); }
    private By AddToCartButton() { return By.cssSelector(webElements.ADD_TO_CART_BUTTON); }
    private By PricesBox() { return By.cssSelector(webElements.PRICES_BOX); }
    //endregion

    //region Actions
    public ProductDetails enterQuantity(){
        fillString(QuantityInput(), String.valueOf(CommonMethods.randomNumber(1, 5)));
        return this;
    }
    public ProductDetails chooseSize() {
        scrollIntoView(SizeCombo());
        selectRandOption(SizeCombo(), false);
        return this;
    }
    public ProductDetails chooseColor(){
        waitForElement(ColorList());
        List<WebElement> colors = driver.findElement(ColorList()).findElements(ColorOptions());
        int index = CommonMethods.randomNumber(0, colors.size() - 1);
        click(colors.get(index));
        waitForAttributeToBe(colors.get(index), "class", "selected");
        return this;
    }
    public ProductDetails saveProductInfo(){
        int reduction = 0;
        float oldPrice = 0;
        String currentPrice = driver.findElement(CurrentPriceLabel()).getText().replace("$", "");

        if(isDisplayed(ReductionLabel())){
            reduction = Integer.parseInt(driver.findElement(ReductionLabel()).getText().substring(1)
                    .replace("%", ""));
            oldPrice = Float.parseFloat(driver.findElement(OldPriceLabel()).getText().replace("$", ""));
            validateReductionOnPrice(reduction, oldPrice, currentPrice);
        }

        product = new Product(
                driver.findElement(NameLabel()).getText(),
                driver.findElement(SkuLabel()).getText(),
                Float.parseFloat(currentPrice),
                reduction,
                oldPrice,
                Integer.parseInt(driver.findElement(QuantityInput()).getAttribute("value")),
                driver.findElement(SelectedSize()).getText().charAt(0),
                driver.findElement(ColorList()).findElement(ColorPicked()).getAttribute("name"),
                driver.findElement(ProductImage()).getAttribute("src")
        );
        product.setTotalPrice(product.getQuantity() * product.getCurrentPrice());

        return this;
    }
    public ProductDetails addToCart(){
        updateCart();
        click(AddToCartButton());
        return this;
    }
    //endregion

    //region Helpers
    private void validateReductionOnPrice(int reduction, float oldPrice, String currentPrice){
        float expected = oldPrice - (oldPrice * reduction / 100);
        assertEquals(PricesBox(), String.format("%.02f", expected).replaceAll(",","."),
                currentPrice.replaceAll(",","."));
    }
    private void updateCart(){
        List<Product> products;
        if(cart == null){
            products = new ArrayList<>();
            cart = new Cart(products);
        }else{
            products = cart.getProducts();
        }
        cart.setCartTotal(cart.getCartTotal() + product.getTotalPrice());
        products.add(product);
        cart.setProducts(products);
    }
    //endregion
}
