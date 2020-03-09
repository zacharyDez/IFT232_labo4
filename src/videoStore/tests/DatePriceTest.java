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
    Price p2;

    String strDate2 = "2020-01-01";
    LocalDate d2 = LocalDate.parse(strDate2, formatter);

    @Before
    public void setup(){
        d = LocalDate.parse(strDate1, formatter);
        dp = new DatePrice();
        p = new NewReleasePrice();
        p2 = new UnpopularPrice();
        dp.addPrice(d, p);
        dp.addPrice(d2, p2);
    }

    @Test
    public void testAddDate(){
        dp.addPrice(d, p);
    }

    @Test
    public void testGetPrice(){
        assertEquals(dp.findPriceByDate(d), p);
        assertEquals(dp.findPriceByDate(d2), p2);

    }
}
