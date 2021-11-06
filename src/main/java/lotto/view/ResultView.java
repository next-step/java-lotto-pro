package lotto.view;

import lotto.model.Rank;

import java.util.Map;

public class ResultView {
    private static final String BOUGHT = "개를 구매했습니다.";
    public static final String STATS = "%d개 일치 (%d원)- %d개\n";

    public static void printBought(int count) {
        System.out.println(count + BOUGHT);
    }
}
