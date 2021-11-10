package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

import java.util.TreeMap;

public class OutputView {
    private static final String PRINT_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_PURCHASE_QUANTITY = "%s개를 구매했습니다.\n";
    private static final String PRINT_INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String PRINT_WINNING_STATISTICS = "당첨 통계\n---------";
    private static final String PRINT_WINNING_STATISTICS_RESULT = "%d개 일치 (%d원)- %s개\n";
    private static final String PRINT_WINNING_STATISTICS_SECOND_RESULT = "%d개 일치, 보너스 볼 일치(%d원)- %s개\n";
    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %.2f 입니다. ";
    private static final String PRINT_RATE_OF_RETURN_LESS_THEN_STANDARD = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OutputView() {
    }

    public static void printPurchaseAmount() {
        System.out.println(PRINT_INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.printf(PRINT_PURCHASE_QUANTITY, purchaseQuantity);
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
        TreeMap<LottoRank, Integer> lottoRankTreeMap = new TreeMap<>(lottoResult.getLottoTicketRankMap());
        lottoRankTreeMap.descendingKeySet().stream()
                .filter(LottoRank::isNotNone)
                .forEach(rank -> checkLottoRank(rank, lottoRankTreeMap));
        printRateOfReturn(lottoResult);
    }

    private static void checkLottoRank(LottoRank rank, TreeMap<LottoRank, Integer> lottoRankTreeMap) {
        if (rank == LottoRank.SECOND) {
            System.out.printf(PRINT_WINNING_STATISTICS_SECOND_RESULT, rank.getMatchCount(), rank.getPrizeMoney(), lottoRankTreeMap.get(rank));
            return;
        }
        System.out.printf(PRINT_WINNING_STATISTICS_RESULT, rank.getMatchCount(), rank.getPrizeMoney(), lottoRankTreeMap.get(rank));
    }

    private static void printRateOfReturn(LottoResult lottoResult) {
        String rateOfReturnMsg = String.format(PRINT_RATE_OF_RETURN, lottoResult.getRateOfReturn());
        if (lottoResult.isRateOfReturnLessThenStandard()) {
            rateOfReturnMsg += PRINT_RATE_OF_RETURN_LESS_THEN_STANDARD;
        }
        System.out.println(rateOfReturnMsg);
    }

}
