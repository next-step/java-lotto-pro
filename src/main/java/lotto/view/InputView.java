package lotto.view;

import lotto.model.*;

import java.util.*;

public class InputView {

    public static Money inputMoneyAndManualCount() {
        try {
            return new Money(InputView.inputBuyAmount(), InputView.inputManualCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoneyAndManualCount();
        }
    }

    public static Lottos inputManualNumbers(int repeatCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < repeatCount; i++) {
            createManualLotto(result);
        }
        return new Lottos(result);
    }

    public static Organizer inputOrganizer() {
        try {
            return new Organizer(InputView.inputWinningNumbers(), InputView.inputBonusNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputOrganizer();
        }
    }

    private static int inputBuyAmount() {
        return inputInteger("구입금액을 입력해 주세요.");
    }

    private static int inputManualCount() {
        return inputInteger("\n수동으로 구매할 로또 수를 입력해 주세요.");
    }

    private static Lotto inputWinningNumbers() {
        try {
            return new Lotto(inputString("\n지난 주 당첨 번호를 입력해 주세요."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private static LottoNo inputBonusNumbers() {
        try {
            return new LottoNo(inputInteger("\n보너스 볼을 입력해 주세요."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumbers();
        }
    }

    private static void createManualLotto(List<Lotto> result) {
        try {
            result.add(new Lotto(inputString("")));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("다시 입력해주세요.");
            createManualLotto(result);
        }
    }

    private static String inputString(String requestMessage) {
        try {
            return newScanner(requestMessage).nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("잘못된 문자 값입니다.");
            return inputString(requestMessage);
        }
    }

    private static int inputInteger(String requestMessage) {
        try {
            return newScanner(requestMessage).nextInt();
        } catch (NoSuchElementException e) {
            System.out.println("잘못된 숫자 값입니다.");
            return inputInteger(requestMessage);
        }
    }

    private static Scanner newScanner() {
        return new Scanner(System.in);
    }

    private static Scanner newScanner(String requestMessage) {
        if (!requestMessage.isEmpty()) {
            System.out.println(requestMessage);
        }
        return newScanner();
    }
}
