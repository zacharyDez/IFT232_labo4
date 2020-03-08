package videoStore;

public class StoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Movie movies[] = new Movie[5];
		
		
		movies[0] = new Movie("Caillou a le cancer", Price.CHILDRENS);
		movies[1] = new Movie("Fast and furious 38: Diesel Cars vs Google Cars", Price.NEW_RELEASE);
		movies[2] = new Movie("31 Jump Street: Ninja Academy", Price.NEW_RELEASE);
		movies[3] = new Movie("Les oiseaux se cachent pour mourir", Price.REGULAR);
		movies[4] = new Movie("Les gars chauds se cachent pour vomir", Price.REGULAR);
		
		
		Customer grandmaman = new Customer("Grand-moman");
		
		grandmaman.addRentals(new Rental(movies[0],4));
		grandmaman.addRentals(new Rental(movies[1],1));
		grandmaman.addRentals(new Rental(movies[2],2));
		grandmaman.addRentals(new Rental(movies[3],7));
		grandmaman.addRentals(new Rental(movies[4],1));
		
		System.out.println(grandmaman.englishStatement());
		System.out.println(grandmaman.frenchStatement());
		
		
		

	}

}
