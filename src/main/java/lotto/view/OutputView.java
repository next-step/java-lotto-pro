package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_PURCHASE_QUANTITY = "%s개를 구매했습니다.\n";

    private OutputView() {
    }

    public static void printPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.printf(PRINT_PURCHASE_QUANTITY, purchaseQuantity);
    }

    public static void printLottoNumber(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        lottoList.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }
}
