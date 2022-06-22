import Coins.Coin;
import Coins.CoinType;
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

    public void giveChange(int changeToGive) {
        coins.clear();

        while (changeToGive > 0) {
            if (changeToGive > 200) {
                Coin coin = new Coin(CoinType.TWOHUNDRED, true);
                addCoin(coin);
                changeToGive -= coin.getCoinType().getValue();
            } else if (changeToGive > 100) {
                Coin coin = new Coin(CoinType.ONEHUNDRED, true);
                addCoin(coin);
                changeToGive -= coin.getCoinType().getValue();
            } else if (changeToGive > 50) {
                Coin coin = new Coin(CoinType.FIFTY, true);
                addCoin(coin);
                changeToGive -= coin.getCoinType().getValue();
            } else if (changeToGive > 20) {
                Coin coin = new Coin(CoinType.TWENTY, true);
                addCoin(coin);
                changeToGive -= coin.getCoinType().getValue();
            } else if (changeToGive > 10) {
                Coin coin = new Coin(CoinType.TEN, true);
                addCoin(coin);
                changeToGive -= coin.getCoinType().getValue();
            } else {
                Coin coin = new Coin(CoinType.FIVE, true);
                addCoin(coin);
                changeToGive -= coin.getCoinType().getValue();
            }
        }
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
                   giveChange(customerMoney - price);
               } else {
                   throw new Exception("Not enough Money");
               }
            } else {
                throw new Exception("Not enough stock");
            }
        }
    }
}
