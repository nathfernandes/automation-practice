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

    public Product(String name, String sku, float currentPrice, int reduction, float oldPrice, int quantity,
                   char size, String color) {
        this.name = name;
        this.sku = sku;
        this.currentPrice = currentPrice;
        this.reduction = reduction;
        this.oldPrice = oldPrice;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
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
}
