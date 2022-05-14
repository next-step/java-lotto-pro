package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REGEX = "[0-9]+";

    private static final String INVALID_PRICE = "1000원 단위의 금액을 입력하세요";
    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private static final int LOTTO_PRICE = 1000;

    public static String inputPrice() {
        System.out.println(INPUT_PRICE);
        String price = scanner.next();
        validateNumber(price);
        validateStandard(price);
        return price;
    }

    public static String inputLottoNumbers() {
        System.out.println(INPUT_NUMBERS);
        return scanner.next();
    }

    private static void validateNumber(String price) {
        if (!price.matches(REGEX)) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateStandard(String price) {
        if (Integer.parseInt(price) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }
}
