package videoStore;

public class NewReleasePrice extends Price {
    public static final int MOV_CODE = 1;

    public NewReleasePrice() {
        super(MOV_CODE);
    }

    @Override
    public double amount(Rental rental) {
        return rental.getDaysRented() * 3;
    }

    @Override
    public int points() {
        return 2;
    }
}
