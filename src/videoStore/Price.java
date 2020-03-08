package videoStore;

public class Price {

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

    public double amount(Rental rental) {
        double thisAmount = 0;

        // determines amount for each line
        switch (priceCode_) {
            case REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public int points() {
        if (priceCode_ == NEW_RELEASE)
            return 2;
        return 1;
    }
}
