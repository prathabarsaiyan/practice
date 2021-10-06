package main.pratha;

import java.util.*;

interface RateService {
    /** This method should return an exchange rate for two currencies.

     Examples:
     EUR -> GBP == 0.88
     GBP -> EUR == 1.14
     GBP -> USD == 1.23

     We pay 0.01 USD for each rate call, and it has 98 % availability.
     */
    Double getRate(Currency c1, Currency c2);
}

enum Currency{
    USD, GBP,EUR;

}
/**
 This is a backend service that should serve Wise customers.
 Customer should see what they'll get if they convert their amount of money to given currency.

 Example:
 Given 100 USD we will get 81.37 GBP.
 This service method is called from outside. 1000 requests per second.
 We would like to be highly available here and to serve the majority of the customers in less than 100 ms.
 */
//@Service
class RateCalculator {
    //@Autowired (aka dependency is injected)
    RateService rateService;

    //(called by frontend)
    public double convert(Currency c1, Currency c2, double amount)  {

        //validation
        Double rate = getRate(c1, c2);
        if(rate == null){
            throw new UnsupportedOperationException();
        }

        return calculateAmount(rate, amount);
    }

    private double calculateAmount(double rate, double amount){
        return rate*amount;
    }

    private static HashMap<String,  ExchangeRate> cache = new HashMap<>();

    Double getRate(Currency C1, Currency C2){
        String key = C1 + "_" + C2 ;// USD_GBP

        if(!cache.containsKey(key) || isExpired(cache.get(key).expiry)){
            cache.put(key, new ExchangeRate(rateService.getRate(C1, C2)));
        }

        return cache.get(key).rate;
    }

    private boolean isExpired(Date expiry){
        return new Date().before(expiry);
    }
}


class ExchangeRate {
    double rate;
    Date expiry;

    ExchangeRate(double rate){
        this.rate = rate;
        expiry = new Date();//now()+1min;
    }
}