package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.type.LottoRank;
import lotto.utils.NumberUtil;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {
    private static final int LOTTO_RANK_MIN_VALUE = 3;
    private static final int LOTTO_PURCHASE_PRICE = 1000;

    private final static String NEW_LINE = "\n";
    private final static String PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private final static String LOTTO_RESULT_MESSAGE = "\n당첨 통계\n---------";
    private final static String LOTTO_RANK_MESSAGE = "%d개 일치 (%d원)- %d개%s";
    private final static String LOTTO_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.%s";

    public static void printPurchaseLottoCount(int purchaseCount) {
        System.out.printf(PURCHASE_LOTTO_COUNT_MESSAGE, purchaseCount);
    }

    public static void printIssuedLottoNumber(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> {
            final List<Integer> lottoNumbers = lotto.getLottoNumbers().stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(lottoNumbers);
        });
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);

        Map<Lotto, LottoRank> lottoLottoRankMap = lottoResult.getLottoResultMap();
        Map<LottoRank, Integer> lottoRankCountMap = new HashMap<>();

        int purchaseLottoPrice = purchaseLottoPrice(lottoLottoRankMap.size());
        int winningLottoPrice = 0;

        for (Lotto lotto : lottoLottoRankMap.keySet())
            putLottoRankCountMap(lottoRankCountMap, lottoLottoRankMap.get(lotto));
        Arrays.sort(lottoRankCountMap.keySet().toArray());

        for (LottoRank lottoRank : lottoRankCountMap.keySet()) {
            Integer lottoRankCount = lottoRankCountMap.get(lottoRank);
            printLottoRankCount(lottoRank.getMatchedCount(), lottoRank.getPrice(), lottoRankCountMap.get(lottoRank));
            winningLottoPrice += (lottoRankCount * lottoRank.getPrice());
        }

        printLottoProfit(lottoProfit(winningLottoPrice, purchaseLottoPrice));
    }

    private static void putLottoRankCountMap(Map<LottoRank, Integer> lottoRankCountMap, LottoRank lottoRank) {
        if (isIncludeLottoRank(lottoRank)) {
            lottoRankCountMap.put(lottoRank, lottoRankCountMap.getOrDefault(lottoRank, 0) + 1);
        }
    }

    private static boolean isIncludeLottoRank(LottoRank lottoRank) {
        return lottoRank.getMatchedCount() >= LOTTO_RANK_MIN_VALUE;
    }

    private static void printLottoRankCount(int matchedCount, int price, int rankCount) {
        System.out.printf(LOTTO_RANK_MESSAGE, matchedCount, price, rankCount, NEW_LINE);
    }

    private static int purchaseLottoPrice(int issuedLottoCount) {
        return LOTTO_PURCHASE_PRICE * issuedLottoCount;
    }

    private static double lottoProfit(int lottoWinningPrice, int lottoPurchasePrice) {
        return NumberUtil.intToDouble(lottoWinningPrice) / NumberUtil.intToDouble(lottoPurchasePrice) ;
    }

    private static void printLottoProfit(double lottoProfit) {
        System.out.printf(LOTTO_PROFIT_MESSAGE, lottoProfit, NEW_LINE);
    }
}
