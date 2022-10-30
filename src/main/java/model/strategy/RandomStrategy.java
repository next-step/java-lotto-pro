package model.strategy;

import java.util.Collections;
import java.util.List;

public class RandomStrategy implements NumberStrategy {

    List<Integer> arrangeLottoNumber;

    private static final int START_ARRANGE_NUMBER = 0;
    private static final int END_ARRANGE_NUMBER = 6;


    public RandomStrategy(List<Integer> arrangeNumber) {
        this.arrangeLottoNumber = arrangeNumber;
    }

    @Override
    public List<Integer> shuffle() {
        Collections.shuffle(arrangeLottoNumber);
        return arrangeLottoNumber.subList(START_ARRANGE_NUMBER, END_ARRANGE_NUMBER);
    }
}
