package lotto.view;

import lotto.model.Rank;

import java.util.Map;

public class ResultView {
    private static final String BOUGHT = "개를 구매했습니다.";
    private static final String YIELD_MESSAGE = "총 수익률은 %f입니다.";

    public static void printBought(int count) {
        System.out.println(count + BOUGHT);
    }

    public static void printYield(double yield) {
        System.out.printf(YIELD_MESSAGE, yield);
    }
}
