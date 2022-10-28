package lotto.view;

public class OutputView {

    private static final String LOTTO_PURCHASE = "%d개를 구매했습니다.";

    public static void lottoPurchaseCount(int count) {
        System.out.println(String.format(LOTTO_PURCHASE, count));
    }

}
