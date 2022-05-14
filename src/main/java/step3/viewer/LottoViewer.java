package step3.viewer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoViewer {
    private static String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static String INPUT_PRICE_ERROR_MESSAGE = "오직 정수만 입력할 수 있습니다.";
    private final Scanner scanner;

    public LottoViewer() {
        this.scanner = new Scanner(System.in);
    }

    public int inputPrice(){
        printMessage(INPUT_PRICE_MESSAGE);
        int price = 0;
        try {
            price = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(INPUT_PRICE_ERROR_MESSAGE);
        }
        return price;
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }
}
