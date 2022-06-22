package Products;

public abstract class Product {

    private final String name;
    private final int price;
    private final String code;
    private int stock;


    public Product(String name, int price, String code, int stock) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int modification) {
        stock += modification;
    }
}
