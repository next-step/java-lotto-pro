package step4.view;

import step4.model.LottoBuyCount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNER_LOTTO_RESULT = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_WINNER_LOTTO_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_BUY_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_BUY_MANUAL_LOTTOS = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String inputLottoBuyMoney() {
        System.out.println(INPUT_BUY_MONEY_MESSAGE);
        return sc.nextLine();
    }

    public static String inputWinnerLottoResult() {
        System.out.println(INPUT_WINNER_LOTTO_RESULT);
        return sc.nextLine();
    }

    public static String inputLottoBonusNumber() {
        System.out.println(INPUT_WINNER_LOTTO_BONUS_NUMBER);
        return sc.nextLine();
    }

    public static String inputBuyManualLottoCount() {
        System.out.println(INPUT_BUY_MANUAL_LOTTO_COUNT);
        return sc.nextLine();
    }

    public static List<String> inputBuyManualLottos(LottoBuyCount lottoBuyCount) {
        List<String> result = new ArrayList<>();
        if (lottoBuyCount.isEqualValue(0)) {
            return result;
        }
        System.out.println(INPUT_BUY_MANUAL_LOTTOS);
        for (LottoBuyCount index = new LottoBuyCount(0); index.isLessThan(lottoBuyCount); index.plus()) {
            result.add(sc.nextLine());
        }
        return result;
    }
}
