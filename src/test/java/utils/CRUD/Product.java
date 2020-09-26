package utils.CRUD;

public class Product {
    private String name;
    private String sku;
    private float currentPrice;
    private int reduction;
    private float oldPrice;
    private int quantity;
    private char size;
    private String color;
    private String imageURL;
    private float totalPrice;

    public Product(String name, String sku, float currentPrice, int reduction, float oldPrice, int quantity,
                   char size, String color, String imageURL) {
        this.name = name;
        this.sku = sku;
        this.currentPrice = currentPrice;
        this.reduction = reduction;
        this.oldPrice = oldPrice;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
        this.imageURL = imageURL;
    }

    public Product(String name, String sku, int quantity, char size, String color, String imageURL, float totalPrice){
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
        this.imageURL = imageURL;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
