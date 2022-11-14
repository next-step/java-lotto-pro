package lotto.view;

import lotto.constant.LottoMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {
    private static final Scanner scan = new Scanner(System.in);
    public static String readMoney() {
        System.out.println(LottoMessage.INPUT_PRICE);
        return scan.nextLine();
    }

    public static String readLottoWinNumber() {
        System.out.println(LottoMessage.INPUT_WIN_LOTTO);
        return scan.nextLine();
    }

    public static String readBonusNumber() {
        System.out.println(LottoMessage.INPUT_BONUS);
        return scan.nextLine();
    }

    public static String readManualLottoCount() {
        System.out.println(LottoMessage.INPUT_MANUAL_LOTTO_COUNT);
        return scan.nextLine();
    }

    public static List<String> readManualLotto(int manualLottoCount) {
        System.out.println(LottoMessage.INPUT_MANUAL_LOTTO);
        List<String> manualLottoStr = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoStr.add(scan.nextLine());
        }
        return manualLottoStr;
    }
}
