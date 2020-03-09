/*
 * Created on 2005-03-07
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package videoStore;

import java.time.LocalDate;

/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * <p>
 * The class Movie is just a simple data class
 */

public class Movie {

    private java.lang.String title_;
    private DatePrice prices = new DatePrice();
    private Price recentPriceCode;
    
    private Movie(String title) {
        title_ = title;
    }

    public static Movie createChildrenMovie(String title, LocalDate date){
        Movie m = new Movie(title);
		m.recentPriceCode = new ChildrensPrice();
		m.prices.addPrice(date, m.recentPriceCode);
		return m;
	}

    public static Movie createChildrenMovie(String title){
        return createChildrenMovie(title, LocalDate.now());
    }

	public static Movie createRegularMovie(String title, LocalDate date){
        Movie m = new Movie(title);
        m.recentPriceCode = new RegularPrice();
        m.prices.addPrice(date, m.recentPriceCode);
        return m;
	}

    public static Movie createRegularMovie(String title){
        return createRegularMovie(title, LocalDate.now());
    }

	public static Movie createNewReleaseMovie(String title, LocalDate date){
        Movie m = new Movie(title);
        m.recentPriceCode = new NewReleasePrice();
        m.prices.addPrice(date, m.recentPriceCode);
        return m;
	}

    public static Movie createNewReleaseMovie(String title){
        return createNewReleaseMovie(title, LocalDate.now());
    }

    public static Movie createUnpopularMovie(String title, LocalDate date){
        Movie m = new Movie(title);
        m.recentPriceCode = new UnpopularPrice();
        m.prices.addPrice(date, m.recentPriceCode);
        return m;
    }

    public static Movie createUnpopularMovie(String title){
        return createUnpopularMovie(title, LocalDate.now());
    }

    public java.lang.String getTitle() {
        return title_;
    }

    public Price getPriceCode() {
        return recentPriceCode;
    }

    public void setPriceCode(int newCode) {
        recentPriceCode.setPriceCode_(newCode);
    }

    public double amount(Rental rental) {
        return recentPriceCode.amount(rental);
    }

    public double amount(Rental rental, LocalDate date) {
        return prices.findPriceByDate(date).amount(rental);
    }

}
