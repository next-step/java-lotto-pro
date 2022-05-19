package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import lotto.domain.LottoUtil;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int[] enterManualLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return LottoUtil.convertToIntArray(enterString().split(","));
    }

    public static String enterString() {
        return SCANNER.next();
    }


    public static int enterNumber() throws InputMismatchException {
        System.out.println("구입금액을 입력해주세요");
        int number;
        while (true) {
            try {
                number = SCANNER.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값을 입력하였습니다");
                SCANNER.next();
            }
        }
    }
}
