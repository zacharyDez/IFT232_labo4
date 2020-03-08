package videoStore;

import java.util.HashMap;

public abstract class Price {

    private int priceCode_;

    public Price(int priceCode) {
        priceCode_ = priceCode;
    }

    public void setPriceCode_(int priceCode_) {
        this.priceCode_ = priceCode_;
    }

    public abstract double amount(Rental rental);

    public int points() {
        return 1;
    }
}
