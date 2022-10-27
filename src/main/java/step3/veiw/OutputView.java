package step3.veiw;

import step3.model.Lotto;
import step3.model.LottoGenerator;
import step3.model.LottoResult;
import step3.model.Lottos;

import static step3.constant.GameMessage.*;

public class OutputView {

    private final static int MIN_SAME_COUNT = 3;
    private final static int MAX_SAME_COUNT = 6;

    public static void outputResultGenerateLotto(Lottos lottos) {
        outputPurchaseCount(lottos);
        outputResultLotto(lottos);
    }

    private static void outputPurchaseCount(Lottos lottos) {
        String purchaseCount = String.valueOf(lottos.getSize());
        System.out.println(new StringBuilder(purchaseCount).append(PURCHASE_COUNT_MESSAGE));
    }

    private static void outputResultLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();

    }

    public static void outputResultLottoGame(LottoGenerator lottoGenerator, LottoResult lottoResult) {
        System.out.println();
        System.out.println(RESULT_STATISTICS);
        System.out.println(DIVIDING_LINE);
        outputSameNumberCount(lottoResult);
        outputResultLottoStatistics(lottoGenerator, lottoResult);
    }

    private static void outputSameNumberCount(LottoResult lottoResult) {
        for (int i = MIN_SAME_COUNT; i <= MAX_SAME_COUNT; i++) {
            System.out.println(lottoResult.createSameCountMessage(i));
        }
    }

    private static void outputResultLottoStatistics(LottoGenerator lottoGenerator, LottoResult lottoResult) {
        System.out.println(lottoResult.createLottoStatisticsMessage(lottoGenerator));
    }

}