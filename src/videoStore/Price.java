package videoStore;

public class Price {

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
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public int points() {
        if (priceCode_ == Movie.NEW_RELEASE)
            return 2;
        return 1;
    }
}
