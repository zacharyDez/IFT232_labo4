package videoStore.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoStore.*;

public class RentalTest {
	
	private final double EPSILON = 0.01;
	private Movie childMovie;
	private Movie regularMovie;
	private Movie newMovie;
	
	@Before
	public void setup() {
		
		

		childMovie = Movie.createChildrenMovie("Caillou a le cancer");
		newMovie = Movie.createNewReleaseMovie("31 Jump Street: Ninja Academy");
		regularMovie = Movie.createRegularMovie("Les oiseaux se cachent pour mourir");
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
		
		
		assertEquals(child1day.movie.amount(child1day),1.5,EPSILON);
		assertEquals(child1day.movie.amount(child1day), child3days.movie.amount(child3days),EPSILON);
		assertEquals(child5days.movie.amount(child5days),4.5,EPSILON);
		assertEquals(reg1day.movie.amount(reg1day),2.0,0.0001);
		assertEquals(reg1day.movie.amount(reg1day), reg2days.movie.amount(reg2days),EPSILON);
		assertEquals(reg5days.movie.amount(reg5days),6.5,EPSILON);
		assertEquals(new1day.movie.amount(new1day),3.0,EPSILON);
		assertEquals(new5days.movie.amount(new5days),15.0,EPSILON);
		
	}
	
	@Test
	public void testPoints(){
		Rental childrens = new Rental(childMovie,1);		
		Rental newrelease = new Rental(newMovie,1);	
		Rental regular = new Rental(regularMovie,5);
		
		assertEquals(newrelease.points(),2);	
		assertEquals(childrens.points(),1);	
		assertEquals(regular.points(),1);	
	}
	
	

	
	@After
	public void teardown() {
		childMovie = null;
		regularMovie=null;
		newMovie=null;
	}
}
