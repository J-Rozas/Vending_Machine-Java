import Coin.Coin;
import Products.Cola;
import Products.Product;

import java.util.ArrayList;
import java.util.Objects;

public class VendingMachine {

    private final ArrayList<Product> products;
    private final ArrayList<Coin> coins;
    private int money;

    public VendingMachine() {
        this.products = new ArrayList<>();
        this.coins = new ArrayList<>();
        this.money = 0;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }

    public int getMoney() {
        return money;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public int getValueCustomerCoins() {
        int totalValue = 0;

        for (Coin coin : getCoins()) {
            totalValue += coin.getCoinType().getValue();
        }

        return totalValue;
    }

    public Product getProductByCode(String code) throws Exception {
        for (Product product : getProducts()) {
            if (Objects.equals(product.getCode(), code)) {
                return product;
            }
        }

        throw new Exception("Product not Found");
    }

    public void sellProduct(String code) throws Exception {
        Product desiredProduct = getProductByCode(code);

        if (desiredProduct != null) {
            int price = desiredProduct.getPrice();
            int stock = desiredProduct.getStock();
            int customerMoney = getValueCustomerCoins();

            if (stock > 0) {
               if (customerMoney >= price) {
                   money += price;
                   desiredProduct.setStock(-1);
                   coins.clear();
               } else {
                   throw new Exception("Not enough Money");
               }
            } else {
                throw new Exception("Not enough stock");
            }
        }
    }
}
