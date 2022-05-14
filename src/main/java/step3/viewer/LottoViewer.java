package step3.viewer;

import java.util.Scanner;
import step3.domain.Lottos;

public class LottoViewer {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PRICE_ERROR_MESSAGE = "오직 정수만 입력할 수 있습니다.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_NOTICE_MESSAGE = "%d개를 구매했습니다.";
    private static final Scanner scanner = new Scanner(System.in);

    private LottoViewer() { }

    public static int inputPrice() {
        printMessage(INPUT_PRICE_MESSAGE);
        int price;
        try {
            price = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_PRICE_ERROR_MESSAGE);
        }
        return price;
    }

    public static String inputWinningNumbers() {
        printMessage(INPUT_WINNING_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

    public static void printLottos(final Lottos lottos) {
        printFormatMessage(PURCHASE_NOTICE_MESSAGE, lottos.size());
        final String[] lottosString = lottos.toStringArray();
        for (final String lottoString : lottosString) {
            printMessage(lottoString);
        }
    }

    private static void printMessage(final String message) {
        System.out.println(message);
    }

    private static void printFormatMessage(final String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }
}
