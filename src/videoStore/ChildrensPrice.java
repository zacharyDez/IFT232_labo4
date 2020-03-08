package videoStore;

public class ChildrensPrice extends Price {
    public static final int MOV_CODE = 2;

    public ChildrensPrice() {
        super(MOV_CODE);
    }

    @Override
    public double amount(Rental rental) {
        double thisAmount = 1.5;
        if (rental.getDaysRented() > 3)
            thisAmount += (rental.getDaysRented() - 3) * 1.5;
        return thisAmount;
    }
}
