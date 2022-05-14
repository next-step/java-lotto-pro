package step3.viewer;

import java.util.InputMismatchException;
import java.util.Scanner;
import step3.domain.Lottos;

public class LottoViewer {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PRICE_ERROR_MESSAGE = "오직 정수만 입력할 수 있습니다.";
    private static final String PURCHASE_NOTICE_MESSAGE = "%d개를 구매했습니다.";
    private final Scanner scanner;

    public LottoViewer() {
        this.scanner = new Scanner(System.in);
    }

    public int inputPrice() {
        printMessage(INPUT_PRICE_MESSAGE);
        int price;
        try {
            price = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(INPUT_PRICE_ERROR_MESSAGE);
        }
        return price;
    }

    public void printLottos(final Lottos lottos) {
        printFormatMessage(PURCHASE_NOTICE_MESSAGE, lottos.size());
        final String[] lottosString = lottos.toStringArray();
        for (final String lottoString : lottosString) {
            printMessage(lottoString);
        }
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }

    private void printFormatMessage(final String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }
}
