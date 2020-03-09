package videoStore.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import videoStore.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class DatePriceTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate d;
    String strDate1 = "2018-12-12";
    DatePrice dp;
    Price p;
    Rental r;
    Movie m = Movie.createUnpopularMovie("Caillou a le cancer", d);


    @Before
    public void setup(){
        d = LocalDate.parse(strDate1, formatter);
        dp = new DatePrice();
        p = new NewReleasePrice();
        r = new Rental(m,1);
        dp.addPrice(d, p);
    }

    @Test
    public void testAddDate(){
        dp.addPrice(d, p);
    }

    @Test
    public void testGetPrice(){
       assertEquals(dp.findPriceByDate(d), p);
    }
}
