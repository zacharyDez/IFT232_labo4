package videoStore;

public class NewReleasePrice extends Price {
    public NewReleasePrice(int priceCode) {
        super(priceCode);
    }

    @Override
    public double amount(Rental rental) {
        return rental.getDaysRented() * 3;
    }
}
