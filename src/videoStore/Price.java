package videoStore;

import java.util.HashMap;

public abstract class Price {

    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;
    public static final int CHILDRENS = 2;
    private int priceCode_;

    public Price(int priceCode) {
        priceCode_ = priceCode;
    }

    public void setPriceCode_(int priceCode_) {
        this.priceCode_ = priceCode_;
    }

    public abstract double amount(Rental rental);

    public int points() {
        if (priceCode_ == NEW_RELEASE)
            return 2;
        return 1;
    }
}
