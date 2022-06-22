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
    public void hasStock() {
        assertEquals(3, crisps.getStock());
    }

    @Test
    public void hasName() {
        assertEquals("Crisps", crisps.getName());
    }

    @Test
    public void hasPrice() {
        assertEquals(50, crisps.getPrice());
    }

    @Test
    public void hasCode() {
        assertEquals("CRI", crisps.getCode());
    }

    @Test
    public void shouldBeAbleToModifyStock() {
        crisps.setStock(-1);
        assertEquals(2, crisps.getStock());
    }
}
