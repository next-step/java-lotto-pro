package lotto;

public class ResultView {

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.allGames()) {
            System.out.println(lotto.printText());
        }
    }
}
