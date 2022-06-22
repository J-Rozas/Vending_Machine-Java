import Coins.Coin;
import Products.Cola;
import Products.Product;
import Coins.CoinType;
import Products.Sweet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void before() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void hasEmptyArrayListOfProducts() {
        assertEquals(new ArrayList<Product>(), vendingMachine.getProducts());
    }

    @Test
    public void hasMoney() {
        assertEquals(0, vendingMachine.getMoney());
    }

    @Test
    public void hasEmptyArrayListOfCoins() {
        assertEquals(new ArrayList<Coin>(), vendingMachine.getCoins());
    }

    @Test
    public void shouldBeAbleToAddNewProduct() {
        Cola cola = new Cola(10);
        vendingMachine.addProduct(cola);
        assertEquals(
                new ArrayList<Product>(Collections.singletonList(cola)),
                vendingMachine.getProducts()
        );
    }

    @Test
    public void shouldBeAbleToAddCustomerCoins() {
        Coin coin = new Coin(CoinType.ONEHUNDRED, true);
        vendingMachine.addCoin(coin);
        vendingMachine.addCoin(coin);
        assertEquals(
                new ArrayList<>(Arrays.asList(coin, coin)),
                vendingMachine.getCoins()
        );
    }

    @Test
    public void canGetValueOfCustomerCoins() {
        Coin coin = new Coin(CoinType.ONEHUNDRED, true);
        vendingMachine.addCoin(coin);
        vendingMachine.addCoin(coin);
        assertEquals(200, vendingMachine.getValueCustomerCoins());
    }

    @Test
    public void canGetProductByCode() throws Exception {
        Cola cola = new Cola(10);
        Sweet sweet = new Sweet(2);
        vendingMachine.addProduct(cola);
        vendingMachine.addProduct(sweet);
        assertEquals(cola, vendingMachine.getProductByCode("COL"));
    }

    @Test
    public void shouldBeAbleToSellProductIfEnoughMoneyCorrectCodeAndEnoughStock() throws Exception {
        Sweet sweet = new Sweet(10);
        Coin coin = new Coin(CoinType.ONEHUNDRED, true);
        vendingMachine.addCoin(coin);
        vendingMachine.addProduct(sweet);
        vendingMachine.sellProduct("SWE");
        assertEquals(65, vendingMachine.getMoney());
        assertEquals(9, sweet.getStock());
        assertEquals(35, vendingMachine.getValueCustomerCoins());
    }

    @Test
    public void shouldBeAbleToReturnCoins() {
        Coin coin = new Coin(CoinType.ONEHUNDRED, true);
        vendingMachine.addCoin(coin);
        vendingMachine.addCoin(coin);
        vendingMachine.addCoin(coin);
        assertEquals(300, vendingMachine.getValueCustomerCoins());
        vendingMachine.returnCoins();
        assertEquals(0, vendingMachine.getValueCustomerCoins());
    }
}
