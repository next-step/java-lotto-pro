package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoPurchaseQuantity;
import lotto.model.LottoRank;
import lotto.model.LottoRanks;

public final class LottoOutputView {
    private static final Long RESULT_DEFAULT_VALUE = 0L;
    private static final String PURCHASE_QUANTITY_MESSAGE = "%s개를 구매했습니다.\n";
    private static final String RANK_RESULT_MESSAGE = "%d개 일치 (%d)원 - %d개\n";

    public static void printPurchaseQuantity(LottoPurchaseQuantity lottoPurchaseQuantity) {
        System.out.printf(PURCHASE_QUANTITY_MESSAGE, lottoPurchaseQuantity.getQuantity());
    }

    public static void printPurchaseLottoNumbers(LottoNumbers lottoNumbers) {
        List<LottoNumber> lottoNumberList = lottoNumbers.getLottoNumbers();
        lottoNumberList.forEach(LottoOutputView::printLottoNumber);
    }

    private static void printLottoNumber(LottoNumber lottoNumber) {
        System.out.println(lottoNumber.getLottoNumber());
    }

    public static void printRankResult(LottoRanks lottoRanks) {
        Map<LottoRank, Long> result = lottoRanks.resultLottoRanks();
        Arrays.asList(LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
                .forEach(rank -> printEachRank(rank, result.getOrDefault(rank, RESULT_DEFAULT_VALUE)));
    }

    private static void printEachRank(LottoRank rank, Long count) {
        System.out.printf(RANK_RESULT_MESSAGE, rank.getHits(), rank.getCashPrize(), count);
    }

    public static void printErrorMessage(RuntimeException re) {
        System.out.println(re.getMessage());
    }
}
