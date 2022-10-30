package model;

import model.strategy.NumberStrategy;

import java.util.Collections;
import java.util.List;

public class LottoNumber {

    List<Integer> number;

    public LottoNumber(NumberStrategy numberStrategy) {
        List<Integer> shuffle = numberStrategy.shuffle();
        Collections.sort(shuffle);
        this.number = shuffle;
    }

    @Override
    public String toString() {
        return "" + number + "";
    }
}
