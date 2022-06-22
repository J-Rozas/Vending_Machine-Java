import Coin.Coin;
import Products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private final ArrayList<Product> products;
    private final ArrayList<Coin> coins;

    public VendingMachine() {
        this.products = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }
}
