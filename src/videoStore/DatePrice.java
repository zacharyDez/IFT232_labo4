package videoStore;

import org.junit.After;

import java.time.LocalDate;
import java.util.*;

public class DatePrice {

    HashMap<LocalDate, Price> prices;

    public DatePrice(){
        prices = new HashMap<>();
    }

    public void addPrice(LocalDate date, Price price){
        prices.put(date, price);
    }

    public Price findPriceByDate(LocalDate date){

        Price priceCode;

        if(prices.isEmpty()){
            throw new IllegalArgumentException();
        }

        ArrayList<LocalDate> dateList = new ArrayList<>(prices.keySet());

        // if size is one simply return price
        if(prices.size()==1){
            return prices.get(dateList.get(0));

        }

        Collections.sort(dateList);

        // find last price corresponding
        int i = 0;
        while(i+1!=dateList.size()){
            // used to check both dates
            LocalDate before = dateList.get(i);
            LocalDate after = dateList.get(i+1);

            if(date.isEqual(before)){
                return prices.get(dateList.get(i));
            }

            if(date.isEqual(after)){
                return prices.get(dateList.get(i+1));
            }

            if(date.isAfter(before) && date.isBefore(after)){
                return prices.get(dateList.get(i));
            }
            i++;
        }

        // reached last element in datelist
        return prices.get(dateList.get(dateList.size()-1));

    }


}
