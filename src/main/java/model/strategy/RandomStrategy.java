package model.strategy;

import java.util.Collections;
import java.util.List;

public class RandomStrategy implements NumberStrategy {

    List<Integer> arrangeLottoNumber;


    public RandomStrategy(List<Integer> arrangeNumber) {
        this.arrangeLottoNumber = arrangeNumber;
    }

    @Override
    public List<Integer> shuffle() {
        Collections.shuffle(arrangeLottoNumber);
        return arrangeLottoNumber.subList(0, 6);
    }
}
