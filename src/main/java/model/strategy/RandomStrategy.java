package model.strategy;

import java.util.Collections;
import java.util.List;

import static common.Constants.END_ARRANGE_NUMBER;
import static common.Constants.START_ARRANGE_NUMBER;

public class RandomStrategy implements NumberStrategy {

    List<Integer> arrangeLottoNumber;


    public RandomStrategy(List<Integer> arrangeNumber) {
        this.arrangeLottoNumber = arrangeNumber;
    }

    @Override
    public List<Integer> shuffle() {
        Collections.shuffle(arrangeLottoNumber);
        return arrangeLottoNumber.subList(START_ARRANGE_NUMBER, END_ARRANGE_NUMBER);
    }
}
