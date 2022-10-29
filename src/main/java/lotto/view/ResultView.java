package lotto.view;

import static lotto.domain.LottoPrize.isNoPrize;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResults;
import lotto.domain.Money;

public class ResultView {

    private static final String PURCHASING_LOTTO_COUNT = "%d개를 구매했습니다." + System.lineSeparator();
    private static final String LOTTO_RESULTS_DIRECTION = "당첨 통계";
    private static final String NEW_LINE = "";
    private static final String DIVISION_LINE = "---------";
    private static final String LOTTO_RESULT = "%d개 일치 (%d원)- %d개" + System.lineSeparator();
    private static final String LOTTO_RESULT_PROFITS = "총 수익률은 %.2f입니다.";
    private static final String LOTTO_LOSS_PROFITS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printExceptionErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printPurchasingLottoCount(int maxLottoCount) {
        System.out.printf(PURCHASING_LOTTO_COUNT, maxLottoCount);
    }

    public static void printPurchasingLottos(List<Lotto> lottos) {
        for(Lotto lotto: lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoResults(LottoResults lottoResults, Money purchaseMoney) {
        System.out.println(NEW_LINE);
        System.out.println(LOTTO_RESULTS_DIRECTION);
        System.out.println(DIVISION_LINE);
        for(LottoPrize lottoPrize: LottoPrize.values()) {
            int lottoResultCount = lottoResults.findLottoResultCount(lottoPrize);
            printLottoResult(lottoPrize, lottoResultCount);
        }
        printLottoResultProfits(lottoResults, purchaseMoney);
    }

    private static void printLottoResult(LottoPrize lottoPrize, int lottoResultCount) {
        if(!isNoPrize(lottoPrize)) {
            System.out.printf(LOTTO_RESULT, lottoPrize.getMatchCount(), lottoPrize.getLottoPrizeMoney(), lottoResultCount);
        }
    }

    private static void printLottoResultProfits(LottoResults lottoResults, Money purchaseMoney) {
        Money totalProfits = lottoResults.findProfits();
        System.out.printf(LOTTO_RESULT_PROFITS, purchaseMoney.findProfitsRatio(totalProfits));
        printIfLossProfits(totalProfits, purchaseMoney);
    }

    private static void printIfLossProfits(Money totalProfits, Money purchaseMoney) {
        if (totalProfits.isLessThan(purchaseMoney)) {
            System.out.print(LOTTO_LOSS_PROFITS);
        }
    }
}
