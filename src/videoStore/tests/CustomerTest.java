package videoStore.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoStore.*;

public class CustomerTest {

	private Customer grandmaman;
	private Movie movies[];
	LocalDate date;
	Rental testDate;

	@Before
	public void setup() {
		movies = new Movie[6];

		movies[0] = Movie.createChildrenMovie("Caillou a le cancer");
		movies[1] = Movie.createNewReleaseMovie("Fast and furious 38: Diesel Cars vs Google Cars");
		movies[2] = Movie.createNewReleaseMovie("31 Jump Street: Ninja Academy");
		movies[3] = Movie.createRegularMovie("Les oiseaux se cachent pour mourir");
		movies[4] = Movie.createRegularMovie("Les gars chauds se cachent pour vomir");
		movies[5] = Movie.createUnpopularMovie("Very unpopular movie");

		grandmaman = new Customer("Grand-moman");

		grandmaman.addRentals(new Rental(movies[0], 4));
		grandmaman.addRentals(new Rental(movies[1], 1));
		grandmaman.addRentals(new Rental(movies[2], 2));
		grandmaman.addRentals(new Rental(movies[3], 7));
		grandmaman.addRentals(new Rental(movies[4], 1));
		grandmaman.addRentals(new Rental(movies[5], 30));

		/*Exemple de création de location avec une date passée*/
		String str = "2018-12-12";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		date = LocalDate.parse(str, formatter);
		testDate = new Rental (movies[0],date,2);
		
	}

	

	@Test
	public void testTotalAmount() {
		assertEquals(grandmaman.totalAmount(), 25.5, 0.0001);
	}

	@Test
	public void testTotalPoints() {

		assertEquals(grandmaman.totalPoints(), 10);
	}

	@Test
	public void testChangeAmount() {
		assertEquals(grandmaman.totalAmount(), 25.5, 0.0001);
		movies[0].addPrice(date, new NewReleasePrice());
		grandmaman.addRentals(testDate);
		assertEquals(grandmaman.totalAmount(), 27, 0.0001);
	}

	@After
	public void teardown() {
		grandmaman = null;
		movies = null;
	}

}
