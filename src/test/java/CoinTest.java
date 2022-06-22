import Coin.Coin;
import Coin.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinTest {

    private Coin one;
    private Coin fifty;

    @Before
    public void before() {
        one = new Coin(CoinType.ONE, false);
        fifty = new Coin(CoinType.FIFTY, true);
    }

    @Test
    public void coinHasPropertyValid() {
        assertFalse(one.getValid());
        assertTrue(fifty.getValid());
    }

    @Test
    public void coinHasValue() {
        assertEquals(1, one.getCoinType().getValue());
        assertEquals(50, fifty.getCoinType().getValue());
    }
}
