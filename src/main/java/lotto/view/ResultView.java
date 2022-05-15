package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoPrizeMap;
import lotto.model.LottoPrizeRank;
import lotto.model.LottoPrizeRanks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.model.LottoPrizeRank.*;

public class ResultView {
    private static final String QUANTITY_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String STATICS_TITLE = "당첨통계\n---------";
    private static final String STATICS_BODY = "%d개 일치 (%d원)- %d개\n";
    private static final String RATIO_MESSAGE = "총 수익률은 %.2f입니다\n";

    private static final List<LottoPrizeRank> table = Arrays.asList(FIFTH, FOURTH, THIRD, FIRST);

    public static void quantity(int quantity) {
        System.out.printf(QUANTITY_MESSAGE, quantity);
    }

    public static void table(List<LottoNumbers> source) {
        for (LottoNumbers lottoNumbers : source) {
            formatLottoNumber(lottoNumbers);
        }
    }

    private static void formatLottoNumber(LottoNumbers lottoNumbers) {
        System.out.print("[");
        for (LottoNumber lottoNumber : lottoNumbers.getNumbers()) {
            System.out.print(lottoNumber + " ");
        }
        System.out.println("]");
    }

    public static void statics(LottoPrizeRanks lottoPrizeRanks) {
        Map<Integer, Long> lottoRankMap = LottoPrizeMap.of(lottoPrizeRanks);
        System.out.println(STATICS_TITLE);
        for (LottoPrizeRank lottoPrizeRank : table) {
            System.out.printf(STATICS_BODY,
                    lottoPrizeRank.getNumberOfMatch(),
                    lottoPrizeRank.getPrize(),
                    lottoRankMap.getOrDefault(lottoPrizeRank.getNumberOfMatch(), 0L));
        }
    }

    public static void showRatio(Float ratio) {
        System.out.printf(RATIO_MESSAGE, ratio);
    }
}
