package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.model.purchased.PurchasedInfo;
import lotto.model.purchased.PurchasedLotto;
import lotto.model.result.LottoResult;
import lotto.type.LottoWinningPriceType;

public class OutputView {

    private OutputView() {
    }

    public static void OutputPurchaseResult(PurchasedInfo purchasedInfo) {
        System.out.printf("%d개를 구매했습니다.%n", purchasedInfo.getPossiblePurchaseCount());

        for (PurchasedLotto purchasedLotto : purchasedInfo.getPurchasedLottos()) {
            System.out.println(purchasedLotto.toLottoNumbersString());
        }
    }

    public static void OutputLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        outputLottoResultMap(lottoResult.getLottoResultMap());
        System.out.printf("총 수익률은 %.2f입니다.", lottoResult.getWinningRate());
    }

    private static void outputLottoResultMap(Map<LottoWinningPriceType, List<PurchasedLotto>> lottoResultMap) {
        lottoResultMap.entrySet().stream()
            .sorted(Comparator.comparingInt(o -> o.getKey().getCorrectCount())).forEach((entrySet) -> {
                System.out.printf("%d개 일치 (%d원)- %d개%n",
                    entrySet.getKey().getCorrectCount(),
                    entrySet.getKey().getWinningPrice(),
                    entrySet.getValue().size());
        });
    }

}
