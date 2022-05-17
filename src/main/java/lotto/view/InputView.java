package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int[] enterManualLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return convertToIntArray(enterString().split(","));
    }

    public static String enterString() {
        return SCANNER.next();
    }

    private static int[] convertToIntArray(String[] lottoString) {
        int[] lottoNumbers = new int[lottoString.length];
        for (int i = 0; i < lottoString.length; i++) {
            lottoNumbers[i] = Integer.parseInt(lottoString[i]);
        }
        return lottoNumbers;
    }

    public static int enterNumber() throws InputMismatchException {
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
