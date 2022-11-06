package step3.view;

import java.util.stream.Collectors;
import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.domain.Rank;
import step3.domain.Rewards;

public class OutputView {
    private static final String RESULT_FORMAT = "%d개 일치 (%d원)- %d개\n";
    private static final String PROFIT_RATE = "총 수익률은 %s입니다.";
    private static final String SECOND_MATCH_COUNT = "%d개 일치, 보너스 볼 일치(%d원)- %d개%n";
    private static final String PURCHASE_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";

    public static void showPurchaseLottoCount(int count) {
        System.out.format(PURCHASE_LOTTO_COUNT, count);
    }

    public static void showPurchasedLottos(Lottos purchasedLottos) {
        String result = purchasedLottos.getLottoList()
            .stream()
            .map(lotto -> printLottos(lotto))
            .collect(Collectors.joining("\n"));

        System.out.println(result);
    }

    public static String printLottos(Lotto lotto) {
        char fisrtCharactor = '[';
        char lastCharactor = ']';
        String printDelimiter = ", ";

        return fisrtCharactor + lotto.getLottoNumbers().getLottoNumberSet().stream()
            .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
            .collect(Collectors.joining(printDelimiter)) +lastCharactor;
    }

    public static void showProfitRate(Rewards rewards) {
        System.out.format(PROFIT_RATE, rewards.calculateRateOfReturn());
    }

    public static void showResults(Rewards rewards) {
        StringBuilder result = new StringBuilder();
        String resultsTitle = "당첨 통계\n---------\n";
        result.append(resultsTitle);

        for (Rank rank : Rank.valuesTheLowestOrder()) {
            result.append(String.format(getResultFormat(rank), rank.matchedCount(), rank.winnings(), rewards.count(rank)));
        }

        System.out.println(result);
    }

    public static String getResultFormat(Rank rank) {
        if (rank == Rank.SECOND) {
            return SECOND_MATCH_COUNT;
        }
        return RESULT_FORMAT;
    }

    public static void printLottosCount(int manual, int auto) {
        System.out.printf(PURCHASE_LOTTO_COUNT, manual, auto);
    }

}
