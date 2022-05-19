package step3.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanIn = new Scanner(System.in);
    private final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final String GET_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final String GET_BONUS_LOTTO = "보너스 볼을 입력해 주세요.";


    public String getMoney() {
        System.out.println(GET_MONEY_MESSAGE);
        return scanIn.nextLine().replace(" ", ""); /* 받아온 String내부에 공백을 제거하기 위해 replace사용 */
    }

    public String getWinnerLotto() {
        System.out.println(GET_LOTTO_MESSAGE);
        return scanIn.nextLine().replace(" ", ""); /* 받아온 String내부에 공백을 제거하기 위해 replace사용 */
    }

    public String getBonusLotto() {
        System.out.println(GET_BONUS_LOTTO);
        return scanIn.nextLine().replace(" ", "");
    }
}
