package videoStore;

public class RegularPrice extends Price {
    public static final int MOV_CODE = 0;

    public RegularPrice() {
        super(MOV_CODE);
    }

    @Override
    public double amount(Rental rental) {
        double thisAmount = 2;
        if (rental.getDaysRented() > 2)
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
        return thisAmount;
    }
}
