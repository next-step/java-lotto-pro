package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class ResultView {

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.allGames()) {
            System.out.println(lotto.printText());
        }
    }

    public static void printWinningResult(Lottos lottos) {
        for (Lotto lotto : lottos.allGames()) {
            System.out.println(lotto.printText());
        }
    }

    public static void printRateOfReturn() {

    }
}
