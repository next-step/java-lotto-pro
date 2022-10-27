package step3.veiw;

import step3.model.Lotto;
import step3.model.Lottos;

import static step3.constant.GameMessage.PURCHASE_COUNT_MESSAGE;

public class OutputView {

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

    }

}