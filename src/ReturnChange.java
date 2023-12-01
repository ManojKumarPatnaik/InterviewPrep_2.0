import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//new BigDecimal(Double.toString(100.00)) is necessary because with double and float, decimal issue comes,
//as in memory it is not stored as it is. read this https://dzone.com/articles/never-use-float-and-double-for-monetary-calculatio
enum Coins {

    HUNDRED(new BigDecimal(Double.toString(100.00))),
    FIFTY(new BigDecimal(Double.toString(50.00))),
    TWENTY(new BigDecimal(Double.toString(20.00))),
    TEN(new BigDecimal(Double.toString(10.00))),
    FIVE(new BigDecimal(Double.toString(5.00))),
    TWO(new BigDecimal(Double.toString(2.00))),
    ONE(new BigDecimal(Double.toString(1.00))),
    HALF_DOLLAR(new BigDecimal(Double.toString(.50))),
    QUATER(new BigDecimal(Double.toString(.25))),
    DIME(new BigDecimal(Double.toString(.10))),
    NICKEL(new BigDecimal(Double.toString(.05))),
    PENNY(new BigDecimal(Double.toString(.01)));


    BigDecimal value;

    Coins(BigDecimal value) {
        this.value = value;
    }
}

public class ReturnChange {

    public static void main(String args[]) {

        Map<String, Integer> result = findChangeCoins(1.33);
        for (Map.Entry<String, Integer> entrySet : result.entrySet()) {
            System.out.println(entrySet.getKey() + ":" + entrySet.getValue());
        }
    }

    private static Map<String, Integer> findChangeCoins(double amtToRefund) {

        BigDecimal amountToRefund = new BigDecimal(Double.toString(amtToRefund));

        Coins[] availableCoins = Coins.values();
        Map<String, Integer> coinsUsed = new HashMap<>();

        while (amountToRefund.compareTo(BigDecimal.ZERO) > 0) {
            for (Coins coin : availableCoins) {

                if (amountToRefund.compareTo( coin.value) >= 0) {

                    amountToRefund = amountToRefund.subtract(coin.value);
                    int numberOfCoinsUsed = 1;
                    if (coinsUsed.containsKey(coin.name())) {
                        numberOfCoinsUsed = numberOfCoinsUsed + coinsUsed.get(coin.name());
                    }
                    coinsUsed.put(coin.name(), numberOfCoinsUsed);
                    break;
                }
            }
        }
        return coinsUsed;
    }
}
