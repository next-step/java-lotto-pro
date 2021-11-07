package lotto.view;

import lotto.exception.LottoActiveNumberException;
import lotto.exception.LottoBonusNumberException;
import lotto.exception.LottoMatchNumberException;
import lotto.exception.LottoPurchaseAmountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.ValidationUtils.*;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public int getUserInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String value = scanner.next();
        purchaseAmountValidation(value);
        return Integer.parseInt(value);
    }

    public List<Integer> getUserInputMatchNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String value = scanner.next();
        matchNumberValidation(value);
        return parseInputStringToNumberList(value);
    }

    public int getUserInputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String value = scanner.next();
        bonusNumberValidation(value);
        return Integer.parseInt(value);
    }

    public List<List<Integer>> getUserInputActiveNumbers() {
        System.out.println("수등으로 구매할 로또 수를 입력해 주세요.");
        String value = scanner.next();
        activeCountValidation(value);
        int count = Integer.parseInt(value);
        List<List<Integer>> activeResult = getActiveNumbers(count);
        return activeResult;
    }

    public List<List<Integer>> getActiveNumbers(int count) {
        List<List<Integer>> activeResult = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        IntStream.range(0, count)
                .forEach(i -> {
                    activeResult.add(parseInputStringToNumberList(scanner.next()));
                });
        activeNumbersValidation(count, activeResult);
        return activeResult;
    }

    public void matchNumberValidation(String inputString) {
        if (isEmpty(inputString)) {
            throw new LottoMatchNumberException("당첨 번호를 입력하세요.");
        }
        if (!isNumberFormat(inputString)) {
            throw new LottoMatchNumberException("당첨 번호는 숫자로만 이루어져야합니다.");
        }
    }

    public void purchaseAmountValidation(String inputString) {
        if (isEmpty(inputString)) {
            throw new LottoPurchaseAmountException("구입 금액을 입력하세요.");
        }
        if (!isNumeric(inputString)) {
            throw new LottoPurchaseAmountException("입력 금액은 숫자로만 입력해야합니다.");
        }
    }

    public void bonusNumberValidation(String inputString) {
        if (isEmpty(inputString)) {
            throw new LottoBonusNumberException("보너스 번호를 입력하세요.");
        }
        if (!isNumeric(inputString)) {
            throw new LottoBonusNumberException("보너스 번호는 숫자로만 입력해야합니다.");
        }
    }

    public void activeCountValidation(String inputString) {
        if (isEmpty(inputString)) {
            throw new LottoActiveNumberException("수동으로 구매할 숫자를 입력하세요.");
        }
        if (!isNumeric(inputString)) {
            throw new LottoActiveNumberException("구매 회수는 숫자로만 입력해야합니다.");
        }
    }

    public void activeNumbersValidation(int count, List<List<Integer>> activeResult) {
        if (count != activeResult.size()) {
            throw new LottoActiveNumberException("수동으로 구매한 로또 수와 입력 번호의 길이가 다릅니다");
        }
    }

    private List<Integer> parseInputStringToNumberList(String inputString) {
        return Arrays.stream(inputString.split(SPLIT_REGEX))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
