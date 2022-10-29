package view;

public class OutputWriter {
    private static final String PRINT_QUANTITY_FORMAT = "%d개를 구매했습니다.";

    public static void answerLottoQuantity(int quantity) {
        System.out.println(String.format(PRINT_QUANTITY_FORMAT, quantity));
    }
}
