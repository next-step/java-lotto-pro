package lotto.view;

public class OutputView {
    private static final String QUANTITY = "개를 구매하였습니다.";

    public static void printQuantity(int n) {
        System.out.println(n + QUANTITY);
    }
}
