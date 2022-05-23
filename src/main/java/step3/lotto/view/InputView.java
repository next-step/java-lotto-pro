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
    private static final String PURCHASE_COMPLETION_GUIDE_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    private static final String INPUT_LAST_WINNINGS_LOTTO_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDE_MESSAGE = "보너스 번호를 입력해주세요.";
    private static final String INPUT_MANUAL_ATTEMPTS_COUNT_GUIDE_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_ATTEMPTS_LOTTOS_GUIDE_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static void printInputPriceGuideMessage() {
        System.out.println(INPUT_PRICE_GUIDE_MESSAGE);
    }

    public static void printPurchaseCompletionAndPublishedLottosGuidMessage(Customer customer) {
        printPurchaseCompletionGuideMessage(customer.getManualAttemptsCount(), customer.getAutoAttemptsCount());
        printLottos(customer.getLottos());
    }

    private static void printPurchaseCompletionGuideMessage(int manualAttemptsCount, int autoAttemptsCount) {
        System.out.println(String.format(PURCHASE_COMPLETION_GUIDE_MESSAGE, manualAttemptsCount, autoAttemptsCount));
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getSortedLottoNumbers());
        }
        System.out.println();
    }

    public static void printInputLastWinningLottoGuideMessage() {
        System.out.println(INPUT_LAST_WINNINGS_LOTTO_GUIDE_MESSAGE);
    }

    public static void printInputBonusNumberGuideMessage() {
        System.out.println(INPUT_BONUS_NUMBER_GUIDE_MESSAGE);
    }

    public static void printInputManualAttemptsCountGuideMessage() {
        System.out.println(INPUT_MANUAL_ATTEMPTS_COUNT_GUIDE_MESSAGE);
    }

    public static void printInputManualAttemptsLottosGuideMessage() {
        System.out.println(INPUT_MANUAL_ATTEMPTS_LOTTOS_GUIDE_MESSAGE);
    }

}
