package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String printConsoleMsg(Messages msg) {
        System.out.println(msg.getMsg());
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static List<String> getManualLottos(int manualLottoCnt) {
        System.out.println(Messages.ASK_LOTTO_NUMBERS.getMsg());
        List<String> inputManualLotto = new ArrayList<>();
        for (int i = 0; i < manualLottoCnt; i++) {
            inputManualLotto.add(scanner.nextLine());
        }

        return inputManualLotto;
    }

}
