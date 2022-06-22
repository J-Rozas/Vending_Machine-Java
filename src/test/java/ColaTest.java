import Products.Cola;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColaTest {

    private Cola cola;

    @Before
    public void before() {
        cola = new Cola(10);
    }

    @Test
    public void colaHasStock() {
        assertEquals(10, cola.getStock());
    }

    @Test
    public void colaHasName() {
        assertEquals("Cola", cola.getName());
    }

    @Test
    public void colaHasPrice() {
        assertEquals(100, cola.getPrice());
    }

    @Test
    public void colaHasCode() {
        assertEquals("COL", cola.getCode());
    }
}
