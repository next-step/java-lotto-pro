package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String BUY_COUNT_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String DASH = "----------";
    private static final String RESULT_TITLE = "당첨 통계";
    private static final String RESULT = "%d개 일치 (%s원) - %d개%n";
    private static final String NUMBER_DIGITS = "###,###";


    public static void printBuyLottos(LottoGame lottoGame) {
        System.out.printf(BUY_COUNT_MESSAGE, lottoGame.getMaxQuantity());
        printLottoNumbers(lottoGame.getLottos());
    }

    private static void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningResult(LottoResult lottoResult) {
        printResultTitle();
        printResult(lottoResult);
    }

    private static void printResultTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println(DASH);
    }

    private static void printResult(LottoResult lottoResult) {
        Arrays.stream(LottoRank.values()).forEach(rank ->
            System.out.printf(RESULT, rank.getMatchCount(), decimalFormat(rank), lottoResult.getWinningCount(rank)));
    }

    private static String decimalFormat(LottoRank lottoRank) {
        return new DecimalFormat(NUMBER_DIGITS).format(lottoRank.getWinningMoney());
    }
}
