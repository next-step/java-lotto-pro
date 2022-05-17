package step3.lotto.view;

import step3.lotto.domain.customer.Customer;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.domain.lotto.Lottos;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:07 오후
 */
public class InputView {

    private static final String INPUT_PRICE_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COMPLETION_GUIDE_MESSAGE = "%s개를 구매했습니다.";
    private static final String LAST_WINNING_LOTTO = "지난 주 당첨 번호를 입력해주세요.";

    public static void printInputPriceGuideMessage() {
        System.out.println(INPUT_PRICE_GUIDE_MESSAGE);
    }

    public static void printPurchaseCompletionAndPublishedLottosGuidMessage(Customer customer) {
        printPurchaseCompletionGuideMessage(customer.getTryCount());
        printLottos(customer.getLottos());
    }

    private static void printPurchaseCompletionGuideMessage(int count) {
        System.out.println(String.format(PURCHASE_COMPLETION_GUIDE_MESSAGE, count));
    }

    private static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printInputLastWinningLottoGuideMessage() {
        System.out.println(LAST_WINNING_LOTTO);
    }
}
