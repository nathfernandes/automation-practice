package utils.CRUD;

import java.util.List;

public class Cart {
    private float cartTotal;
    private float shipping;
    private List<Product> products;

    public Cart(){}

    public Cart(List<Product> products){
        this.products = products;
    }

    public float getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(float cartTotal) {
        this.cartTotal = cartTotal;
    }

    public float getShipping() {
        return shipping;
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
