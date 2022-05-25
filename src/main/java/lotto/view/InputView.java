package lotto.view;

import lotto.Lotto;
import lotto.Lottos;
import lotto.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

public class InputView {

    private static final String ASK_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_MANUAL_NUMBER_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String BLANK = " ";
    private static final String DELIMITER = ",";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println(ASK_PRICE_MESSAGE);
        int price = scanner.nextInt();
        scanner.nextLine();
        return price;
    }

    public static int inputManualNumberCount(int maxQuantity) {
        System.out.println(ASK_MANUAL_NUMBER_COUNT_MESSAGE);
        int manualCount = scanner.nextInt();
        if (manualCount > maxQuantity) {
            throw new IllegalArgumentException("수동으로 구매할 로또의 수가 최대 발급 수를 초과했습니다.");
        }
        scanner.nextLine();
        return manualCount;
    }

    public static Lottos inputManualNumbers(int manualCount) {
        System.out.println(ASK_MANUAL_NUMBERS_MESSAGE);
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < manualCount; i++) {
            String[] numbers = scanner.nextLine().replace(BLANK, "").split(DELIMITER);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public static List<Number> inputWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS_MESSAGE);
        String[] inputs = scanner.nextLine().replace(BLANK, "").split(DELIMITER);
        return Arrays.stream(inputs).map(Number::new).collect(toList());
    }

    public static int inputBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

}
