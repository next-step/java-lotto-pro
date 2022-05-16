package lotto.view;

import java.util.Comparator;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.result.LottoResult;

public class OutputView {

    private OutputView() {
    }

    public static void OutputPurchaseResult(int possiblePurchaseLotto, List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", possiblePurchaseLotto);

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static void OutputLottoResult(LottoResult lottoResult, double winningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        outputLottoResultMap(lottoResult);
        System.out.printf("총 수익률은 %.2f입니다.", winningRate);
    }

    private static void outputLottoResultMap(LottoResult lottoResult) {
        lottoResult.getLottoResultMap().entrySet().stream()
            .sorted(Comparator.comparingInt(o -> o.getKey().getCorrectCount())).forEach((entrySet) -> {
                System.out.printf("%d개 일치 (%d원)- %d개%n",
                    entrySet.getKey().getCorrectCount(),
                    entrySet.getKey().getWinningPrice(),
                    entrySet.getValue());
        });
    }

}
