package lotto.view;

import lotto.infrastructure.util.StringUtils;
import lotto.interfaces.dto.LottoRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String NUMBER_SPLIT_REGEX = ",";
    private static final String INPUT_PAY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public LottoRequest.PurchaseRequest inputPurchaseInfo() {
        int payAmount = inputPayAmount();

        int manualLottoCount = inputManualLottoCount();

        List<List<Integer>> manualLottoNumbers = inputManualLottoNumbers(manualLottoCount);

        return new LottoRequest.PurchaseRequest(payAmount, manualLottoCount, manualLottoNumbers);
    }

    private int inputPayAmount() {
        System.out.println(INPUT_PAY_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    private int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    private List<List<Integer>> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER);

        return Stream.generate(() -> scanner.nextLine())
                .map(str -> StringUtils.splitAndTrim(str, NUMBER_SPLIT_REGEX))
                .map(Arrays::asList)
                .map(StringUtils::convertIntegers)
                .limit(manualLottoCount)
                .collect(Collectors.toList());
    }

    public LottoRequest.ResultRequest inputWinningNumbers() {
        System.out.println(INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE);
        String[] winningNumbers = StringUtils.splitAndTrim(scanner.nextLine(), NUMBER_SPLIT_REGEX);

        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        String bonusBall = scanner.nextLine();
        return new LottoRequest.ResultRequest(winningNumbers, bonusBall);
    }
}
