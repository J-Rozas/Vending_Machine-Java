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
    public void hasStock() {
        assertEquals(3, sweet.getStock());
    }

    @Test
    public void hasName() {
        assertEquals("Sweet", sweet.getName());
    }

    @Test
    public void hasPrice() {
        assertEquals(65, sweet.getPrice());
    }

    @Test
    public void hasCode() {
        assertEquals("SWE", sweet.getCode());
    }

    @Test
    public void shouldBeAbleToModifyStock() {
        sweet.setStock(-1);
        assertEquals(2, sweet.getStock());
    }
}
