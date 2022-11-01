package step3.veiw;

import step3.model.Lotto;
import step3.model.LottoResult;
import step3.model.Lottos;

import static step3.constant.GameMessage.*;
import static step3.constant.Rank.*;

public class OutputView {

    public static void outputResultGenerateLotto(Lottos lottos) {
        outputPurchaseCount(lottos);
        outputResultLotto(lottos);
    }

    private static void outputPurchaseCount(Lottos lottos) {
        String purchaseCount = String.valueOf(lottos.getSize());
        System.out.println();
        System.out.println(new StringBuilder(purchaseCount).append(PURCHASE_COUNT_MESSAGE));
    }

    private static void outputResultLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();

    }

    public static void outputResultLottoGame(int lottoSize, LottoResult lottoResult) {
        System.out.println();
        System.out.println(RESULT_STATISTICS);
        System.out.println(DIVIDING_LINE);
        outputSameNumberCount(lottoResult);
        outputResultLottoStatistics(lottoSize, lottoResult);
    }

    private static void outputSameNumberCount(LottoResult lottoResult) {
        System.out.println(lottoResult.createSameCountMessage(FIFTH));
        System.out.println(lottoResult.createSameCountMessage(FOURTH));
        System.out.println(lottoResult.createSameCountMessage(THIRD));
        System.out.println(lottoResult.createSameCountMessage(SECOND));
        System.out.println(lottoResult.createSameCountMessage(FIRST));
    }

    private static void outputResultLottoStatistics(int lottoSize, LottoResult lottoResult) {
        System.out.println(lottoResult.createLottoStatisticsMessage(lottoSize));
    }

}