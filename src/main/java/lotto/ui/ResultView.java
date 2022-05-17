package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosResults;
import lotto.domain.PurchaseMoney;
import lotto.enums.LottoRank;

public class ResultView {
    private static final String MESSAGE_PURCHASE_LOTTO = "%d개를 구매했습니다.";
    private static final String MESSAGE_TITLE_RESULT_STATISTICS = "당첨 통계";
    private static final String MESSAGE_SPLIT_LINE = "---------";
    private static final String MESSAGE_LOTTO_RESULT = "%d개 일치 (%d원)- %d개";
    private static final String MESSAGE_STATISTICS_RESULT = "총 수익률은 %f입니다.(%s)";
    private static final String MESSAGE_LOTTO_FAIL = "기준이 1이기 때문에 결과적으로 손해라는 의미임";
    private static final String MESSAGE_LOTTO_SUCCESS = "대박남 역시 인생은 한방임.";

    private static final String PREFIX_LOTTO_NUMBERS = "[";
    private static final String SUFFIX_LOTTO_NUMBERS = "]";
    private static final String DELIMITER_LOTTO_NUMBERS = ", ";


    public void printPurchasedLottos(Lottos lottos) {
        printAmountOfPurchasedLottos(lottos);
        printLottos(lottos);
    }

    private void printAmountOfPurchasedLottos(Lottos lottos) {
        System.out.println(String.format(MESSAGE_PURCHASE_LOTTO, lottos.size()));
    }

    private void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            printLotto(lottos.get(i));
        }
    }

    private void printLotto(Lotto lotto) {
        System.out.print(PREFIX_LOTTO_NUMBERS);

        for (int i = 0; i < lotto.size() - 1; i++) {
            System.out.print(lotto.get(i).getNumber());
            System.out.print(DELIMITER_LOTTO_NUMBERS);
        }

        System.out.print(lotto.get(lotto.size() - 1).getNumber());
        System.out.println(SUFFIX_LOTTO_NUMBERS);
    }

    public void printLottoStatisticsResult(LottosResults results, PurchaseMoney purchaseMoney) {
        printLottoStatisticsResultTitle();
        printLottosResults(results);
        printEarningsRate(results, purchaseMoney);
    }

    private void printLottoStatisticsResultTitle() {
        System.out.println();
        System.out.println(MESSAGE_TITLE_RESULT_STATISTICS);
        System.out.println(MESSAGE_SPLIT_LINE);
    }

    private void printLottosResults(LottosResults results) {
        printLottosResult(results, LottoRank.FIFTH);
        printLottosResult(results, LottoRank.FOURTH);
        printLottosResult(results, LottoRank.THIRD);
        printLottosResult(results, LottoRank.FIRST);
    }

    private void printLottosResult(LottosResults results, LottoRank rank) {
        System.out.println(String.format(MESSAGE_LOTTO_RESULT, rank.getCountOfMatch(), rank.getWinningMoney(),
                results.getRankCount(rank)));
    }

    private void printEarningsRate(LottosResults results, PurchaseMoney purchaseMoney) {
        double earningsRate = purchaseMoney.calculateEarningsRate(results.calculateTotalMoney());
        System.out.println(String.format(MESSAGE_STATISTICS_RESULT, earningsRate,
                earningsRate < 1 ? MESSAGE_LOTTO_FAIL : MESSAGE_LOTTO_SUCCESS));
    }
}
