import Products.Sweet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SweetTest {

    private Sweet sweet;

    @Before
    public void before() {
        sweet = new Sweet(3);
    }

    @Test
    public void colaHasStock() {
        assertEquals(3, sweet.getStock());
    }

    @Test
    public void colaHasName() {
        assertEquals("Sweet", sweet.getName());
    }

    @Test
    public void colaHasPrice() {
        assertEquals(65, sweet.getPrice());
    }

    @Test
    public void colaHasCode() {
        assertEquals("SWE", sweet.getCode());
    }
}
