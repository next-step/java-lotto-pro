package model;

import model.strategy.NumberStrategy;

import java.util.Collections;
import java.util.List;

import static common.Constants.ADD_WIN_NUMBER_COUNT;

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

    public int getWinNumberCount(List<Integer> winNumber) {
        int winNumberCount = 0;
        for (Integer targetNumber : number) {
            winNumberCount = addCountIfContain(winNumber, targetNumber, winNumberCount);
        }

        return winNumberCount;
    }

    private int addCountIfContain(List<Integer> winNumber, Integer targetNumber, int winNumberCount) {
        if (winNumber.contains(targetNumber)) {
            winNumberCount += ADD_WIN_NUMBER_COUNT;
        }

        return winNumberCount;
    }
}
