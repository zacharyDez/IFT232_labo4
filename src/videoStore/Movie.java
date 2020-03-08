/*
 * Created on 2005-03-07
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package videoStore;

/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * <p>
 * The class Movie is just a simple data class
 */

public class Movie {

    private java.lang.String title_;
    private Price priceCode_;
    
    private Movie(String title) {
        title_ = title;
    }

    public static Movie createChildrenMovie(String title){
        Movie m = new Movie(title);
		m.priceCode_ = new ChildrensPrice(ChildrensPrice.MOV_CODE);
		return m;
	}

	public static Movie createRegularMovie(String title){
        Movie m = new Movie(title);
        m.priceCode_ = new RegularPrice(RegularPrice.MOV_CODE);
        return m;
	}

	public static Movie createNewReleaseMovie(String title){
        Movie m = new Movie(title);
        m.priceCode_ = new NewReleasePrice(NewReleasePrice.MOV_CODE);
        return m;
	}
	
    public java.lang.String getTitle() {
        return title_;
    }

    public Price getPriceCode() {
        return priceCode_;
    }

    public void setPriceCode(int newCode) {
        priceCode_.setPriceCode_(newCode);
    }

    public double amount(Rental rental) {
        return priceCode_.amount(rental);
    }
}
