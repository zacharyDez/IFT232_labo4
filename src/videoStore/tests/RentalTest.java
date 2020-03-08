package videoStore.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoStore.*;

import java.time.LocalDate;

public class RentalTest {
	
	private final double EPSILON = 0.01;
	private Movie childMovie;
	private Movie regularMovie;
	private Movie newMovie;
	private Movie unpopularMovie;
	
	@Before
	public void setup() {
		childMovie = Movie.createChildrenMovie("Caillou a le cancer", LocalDate.now());
		newMovie = Movie.createNewReleaseMovie("31 Jump Street: Ninja Academy", LocalDate.now());
		regularMovie = Movie.createRegularMovie("Les oiseaux se cachent pour mourir", LocalDate.now());
		unpopularMovie = Movie.createUnpopularMovie("Very unpopular movie", LocalDate.now());
	}
	
	
	@Test
	public void testAmount(){
		Rental child1day = new Rental(childMovie,1);
		Rental child3days = new Rental(childMovie,3);
		Rental child5days = new Rental(childMovie,5);
		Rental new1day = new Rental(newMovie,1);
		Rental new5days = new Rental(newMovie,5);
		Rental reg1day = new Rental(regularMovie,1);
		Rental reg2days = new Rental(regularMovie,2);
		Rental reg5days = new Rental(regularMovie,5);
		Rental unpop1days = new Rental(unpopularMovie, 1);
		Rental unpop3days = new Rental(unpopularMovie, 3);
		Rental unpop5days = new Rental(unpopularMovie, 5);

		assertEquals(child1day.movie.amount(child1day),1.5,EPSILON);
		assertEquals(child1day.movie.amount(child1day), child3days.movie.amount(child3days),EPSILON);
		assertEquals(child5days.movie.amount(child5days),4.5,EPSILON);
		assertEquals(reg1day.movie.amount(reg1day),2.0,0.0001);
		assertEquals(reg1day.movie.amount(reg1day), reg2days.movie.amount(reg2days),EPSILON);
		assertEquals(reg5days.movie.amount(reg5days),6.5,EPSILON);
		assertEquals(new1day.movie.amount(new1day),3.0,EPSILON);
		assertEquals(new5days.movie.amount(new5days),15.0,EPSILON);
		assertEquals(unpop1days.movie.amount(unpop1days), 2, EPSILON);
		assertEquals(unpop3days.movie.amount(unpop3days), 2, EPSILON);
		assertEquals(unpop5days.movie.amount(unpop5days), 2, EPSILON);

	}
	
	@Test
	public void testPoints(){
		Rental childrens = new Rental(childMovie,1);		
		Rental newrelease = new Rental(newMovie,1);	
		Rental regular = new Rental(regularMovie,5);
		Rental unpopular = new Rental(unpopularMovie, 1);

		assertEquals(newrelease.points(),2);	
		assertEquals(childrens.points(),1);	
		assertEquals(regular.points(),1);

		assertEquals(unpopular.points(), 3);
	}
	
	

	
	@After
	public void teardown() {
		childMovie = null;
		regularMovie=null;
		newMovie=null;
	}
}
