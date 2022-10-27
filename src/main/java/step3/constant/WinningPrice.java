package step3.constant;

import java.util.HashMap;
import java.util.Map;

public class WinningPrice {

    public static final Map<Integer, Integer> price = new HashMap<>();

    public static void initWinningPrice() {
        price.put(3, 5000);
        price.put(4, 50000);
        price.put(5, 1500000);
        price.put(6, 2000000000);
    }

}
