package lotto.view;

public class ResultView {

    private static final String QUANTITY_PRINT_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public static void printLottoQuantity(int quantity) {
        String message = String.format(QUANTITY_PRINT_MESSAGE_FORMAT, quantity);
        System.out.println(message);
    }

}
