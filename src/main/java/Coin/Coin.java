package Coin;

public class Coin {

    private final CoinType coinType;
    private final boolean valid;

    public Coin(CoinType coinType, boolean valid) {
        this.coinType = coinType;
        this.valid = valid;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public boolean getValid() {
        return this.valid;
    }
}
