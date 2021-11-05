package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {
    private static final String PRINT_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_PURCHASE_QUANTITY = "%s개를 구매했습니다.\n";
    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";
    private static final String PRINT_WINNING_STATISTICS = "당첨 통계\n---------";
    private static final String PRINT_FOURTH_RANK = "3개 일치 (5000원)- %s개\n";
    private static final String PRINT_THIRD_RANK = "4개 일치 (50000원)- %s개\n";
    private static final String PRINT_SECOND_RANK = "5개 일치 (1500000원)- %s개\n";
    private static final String PRINT_FIRST_RANK = "6개 일치 (2000000000원)- %s개\n";

    private OutputView() {
    }

    public static void printPurchaseAmount() {
        System.out.println(PRINT_INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.printf(PRINT_PURCHASE_QUANTITY, purchaseQuantity);
    }

    public static void printLottoNumber(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        lottoList.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    public static void printWinningStatistics(Lottos lottos) {
        System.out.println(PRINT_WINNING_STATISTICS);
        System.out.printf(PRINT_FOURTH_RANK, lottos.getTotalRankCount(LottoRank.FOURTH));
        System.out.printf(PRINT_THIRD_RANK, lottos.getTotalRankCount(LottoRank.THIRD));
        System.out.printf(PRINT_SECOND_RANK, lottos.getTotalRankCount(LottoRank.SECOND));
        System.out.printf(PRINT_FIRST_RANK, lottos.getTotalRankCount(LottoRank.FIRST));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(PRINT_RATE_OF_RETURN, rateOfReturn);
    }
}
