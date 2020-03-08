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
 * 
 * The class Movie is just a simple data class
 */

public class Movie {
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;

	private java.lang.String title_;
	private int priceCode_;

	public Movie(String title, int priceCode) {
		title_ = title;
		priceCode_ = priceCode;
	}

	public java.lang.String getTitle() {
		return title_;
	}

	public int getPriceCode() {
		return priceCode_;
	}

	public void setPriceCode(int newCode) {
		priceCode_ = newCode;
	}

	public double amount(Rental rental) {
		double thisAmount = 0;

		// determines amount for each line
		switch (getPriceCode()) {
		case REGULAR:
			thisAmount += 2;
			if (rental.getDaysRented() > 2)
				thisAmount += (rental.getDaysRented() - 2) * 1.5;
			break;
		case NEW_RELEASE:
			thisAmount += rental.getDaysRented() * 3;
			break;
		case CHILDRENS:
			thisAmount += 1.5;
			if (rental.getDaysRented() > 3)
				thisAmount += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}
}
