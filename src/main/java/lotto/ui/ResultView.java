package lotto.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
    private static final String MESSAGE_LOTTO_RESULT_BONUS = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
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

        List<Integer> lottoNumbers = getSortedLottoNumbers(lotto);
        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            System.out.print(lottoNumbers.get(i));
            System.out.print(DELIMITER_LOTTO_NUMBERS);
        }

        System.out.print(lottoNumbers.get(lottoNumbers.size() - 1));
        System.out.println(SUFFIX_LOTTO_NUMBERS);
    }

    private List<Integer> getSortedLottoNumbers(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < lotto.size(); i++) {
            numbers.add(lotto.get(i).getNumber());
        }
        numbers.sort(null);

        return numbers;
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
        printLottosResult(results, LottoRank.SECOND);
        printLottosResult(results, LottoRank.FIRST);
    }

    private void printLottosResult(LottosResults results, LottoRank rank) {
        String message = MESSAGE_LOTTO_RESULT;
        if (rank.equals(LottoRank.SECOND)) {
            message = MESSAGE_LOTTO_RESULT_BONUS;
        }

        System.out.println(String.format(message, rank.getCountOfMatch(), rank.getWinningMoney(),
                results.getRankCount(rank)));
    }

    private void printEarningsRate(LottosResults results, PurchaseMoney purchaseMoney) {
        double earningsRate = purchaseMoney.calculateEarningsRate(results.calculateTotalMoney());
        System.out.println(String.format(MESSAGE_STATISTICS_RESULT, earningsRate,
                earningsRate < 1 ? MESSAGE_LOTTO_FAIL : MESSAGE_LOTTO_SUCCESS));
    }
}
