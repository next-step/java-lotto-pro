package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.RateOfReturn;

import java.util.NavigableMap;

public class OutputView {
    private static final String PRINT_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_PURCHASE_QUANTITY = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String PRINT_MANUAL_PURCHASE_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PRINT_INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PRINT_INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String PRINT_WINNING_STATISTICS = "당첨 통계\n---------";
    private static final String PRINT_WINNING_STATISTICS_RESULT = "%d개 일치 (%d원)- %d개\n";
    private static final String PRINT_WINNING_STATISTICS_SECOND_RESULT = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %s 입니다. ";
    private static final String PRINT_RATE_OF_RETURN_LESS_THEN_STANDARD = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OutputView() {
    }

    public static void printPurchaseAmount() {
        System.out.println(PRINT_INPUT_PURCHASE_AMOUNT);
    }

    public static void printManualPurchaseQuantity() {
        System.out.println();
        System.out.println(PRINT_MANUAL_PURCHASE_QUANTITY);
    }

    public static void printInputManualLottoNumbers() {
        System.out.println();
        System.out.println(PRINT_INPUT_MANUAL_LOTTO_NUMBERS);
    }

    public static void printPurchaseQuantity(LottoPurchase lottoPurchase) {
        System.out.println();
        System.out.printf(PRINT_PURCHASE_QUANTITY, lottoPurchase.getManualPurchaseQuantity(), lottoPurchase.getAutoPurchaseQuantity());
    }

    public static void printLottoNumber(LottoTicket lottoTicket) {
        lottoTicket.getLottoTicket().stream()
                .map(LottoNumbers::getLottoNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printInputWinningNumbers() {
        System.out.println(PRINT_INPUT_WINNING_NUMBERS);
    }

    public static void printInputLottoBonusNumber() {
        System.out.println(PRINT_INPUT_BONUS_NUMBER);
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println();
        System.out.println(PRINT_WINNING_STATISTICS);
        NavigableMap<LottoRank, Long> rankResult = lottoResult.getRankResult();
        rankResult.descendingKeySet().stream()
                .filter(LottoRank::isNotNone)
                .forEach(rank -> checkLottoRank(rank, rankResult));
    }

    private static void checkLottoRank(LottoRank rank, NavigableMap<LottoRank, Long> lottoRankTreeMap) {
        if (rank == LottoRank.SECOND) {
            System.out.printf(PRINT_WINNING_STATISTICS_SECOND_RESULT, rank.getMatchCount(), rank.getPrizeMoney(), lottoRankTreeMap.get(rank));
            return;
        }
        System.out.printf(PRINT_WINNING_STATISTICS_RESULT, rank.getMatchCount(), rank.getPrizeMoney(), lottoRankTreeMap.get(rank));
    }

    public static void printRateOfReturn(RateOfReturn rateOfReturn) {
        String rateOfReturnMsg = String.format(PRINT_RATE_OF_RETURN, rateOfReturn);
        if (rateOfReturn.isRateOfReturnLessThenStandard()) {
            rateOfReturnMsg += PRINT_RATE_OF_RETURN_LESS_THEN_STANDARD;
        }
        System.out.println(rateOfReturnMsg);
    }

}
