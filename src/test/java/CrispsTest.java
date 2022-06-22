import Products.Cola;
import Products.Crisps;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrispsTest {

    private Crisps crisps;

    @Before
    public void before() {
        crisps = new Crisps(3);
    }

    @Test
    public void colaHasStock() {
        assertEquals(3, crisps.getStock());
    }

    @Test
    public void colaHasName() {
        assertEquals("Crisps", crisps.getName());
    }

    @Test
    public void colaHasPrice() {
        assertEquals(50, crisps.getPrice());
    }

    @Test
    public void colaHasCode() {
        assertEquals("CRI", crisps.getCode());
    }
}
