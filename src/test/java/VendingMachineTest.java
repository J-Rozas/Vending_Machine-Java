import Coin.Coin;
import Products.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
    public void hasEmptyArrayListOfCoins() {
        assertEquals(new ArrayList<Coin>(), vendingMachine.getCoins());
    }

}
