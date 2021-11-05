package lotto.common;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final int MIN_RANGE_VALUE = 1;
    public static final int MAX_RANGE_VALUE = 45;
    public static final int GET_NUMBER_COUNT = 6;
    public static final int GAME_PRICE = 1000;
    public static final Map<Integer, Integer> PRIZE_MONEY = new HashMap<Integer, Integer>(){{
        put(3, 5000);
        put(4, 50000);
        put(5, 1500000);
        put(6, 2000000000);
    }};

}
