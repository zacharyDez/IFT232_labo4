package videoStore;

public class UnpopularPrice extends Price {

    public static final int MOV_CODE = 3;

    public UnpopularPrice() {
        super(MOV_CODE);
    }

    @Override
    public double amount(Rental rental) {
         return 2;
    }

    @Override
    public int points(){
        return 3;
    }
}
