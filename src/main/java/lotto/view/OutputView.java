package lotto.view;

import java.util.Comparator;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.purchase.PurchaseLotto;
import lotto.model.result.LottoResult;
import lotto.type.LottoRank;

public class OutputView {

    private OutputView() {
    }

    public static void OutputPurchaseResult(PurchaseLotto purchaseLotto) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", purchaseLotto.manualLottoCount(), purchaseLotto.autoLottoCount());

        for (Lotto lotto : purchaseLotto.concatLottoList()) {
            System.out.println(lotto.toString());
        }
    }

    public static void OutputLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        outputLottoResultMap(lottoResult);
        System.out.printf("총 수익률은 %.2f입니다.", lottoResult.getWinningRate());
    }

    private static void outputLottoResultMap(LottoResult lottoResult) {
        lottoResult.getLottoResultMap().entrySet().stream()
            .filter(lottoRankIntegerEntry -> !lottoRankIntegerEntry.getKey().equals(LottoRank.NONE))
            .sorted(Comparator.comparingInt(o -> o.getKey().getCorrectCount())).forEach((entrySet) -> {
                System.out.printf("%d개 일치 (%d원)- %d개%n",
                    entrySet.getKey().getCorrectCount(),
                    entrySet.getKey().getWinningPrice(),
                    entrySet.getValue());
        });
    }

}
