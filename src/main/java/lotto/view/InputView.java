package lotto.view;

import lotto.constant.ViewMessageConst;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scan = new Scanner(System.in);

    public static String readMoney(){
        System.out.println(ViewMessageConst.INPUT_MESSAGE_PURCHASE_MONEY);
        return scan.nextLine();
    }

    public static String readLottoWinningNumber() {
        System.out.println(ViewMessageConst.INPUT_MESSAGE_WINNING_NUMBER);
        return scan.nextLine();
    }

    public static String readBonusNumber() {
        System.out.println(ViewMessageConst.INPUT_MESSAGE_BONUS_NUMBER);
        return scan.nextLine();
    }

    public static String readManualLottosCount() {
        System.out.println(ViewMessageConst.INPUT_MESSAGE_MANUAL_LOTTOS_COUNT);
        return scan.nextLine();
    }

    public static void guideMessageToReadManualLottoNumbers() {
        System.out.println(ViewMessageConst.INPUT_MESSAGE_MANUAL_LOTTOS_NUMBER);
    }

    public static String readSimpleLottoNumbers(){
        return scan.nextLine();
    }
}
