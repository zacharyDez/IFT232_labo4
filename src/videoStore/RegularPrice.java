package videoStore;

public class RegularPrice extends Price {
    public RegularPrice(int priceCode) {
        super(priceCode);
    }

    @Override
    public double amount(Rental rental) {
        double thisAmount = 2;
        if (rental.getDaysRented() > 2)
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
        return thisAmount;
    }
}
