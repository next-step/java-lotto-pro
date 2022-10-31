package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoStore {

    private static final String WINNING_NUMBER_INPUT_SPLIT_DELIMETER = ", |,";

    public void entrance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구매 금액을 입력해 주세요.");
        LottoBag lottoList = LottoIssuer.issue(
                new Money(scanner.nextLine()), new LottoNumberGenerator());

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        LottoIssuer.result(lottoList, makeWinningNumbers(scanner.nextLine()));
    }

    private List<Integer> makeWinningNumbers(String input) {
        validInput(input);
        return Arrays.stream(input.split(WINNING_NUMBER_INPUT_SPLIT_DELIMETER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validInput(String input) {
        validInputSize(input);
        validInputNumber(input);
        validDuplicateNumber(input);
    }

    private void validInputSize(String input) {
        int inputSize = (int) Arrays.stream(input.split(WINNING_NUMBER_INPUT_SPLIT_DELIMETER)).count();
        if (inputSize < 6) {
            throw new IllegalArgumentException("당첨 번호는 6개 여야 합니다");
        }
    }

    private void validInputNumber(String input) {
        try {
            Arrays.stream(input.split(WINNING_NUMBER_INPUT_SPLIT_DELIMETER))
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("당첨 번호는 모두 숫자여야 합니다");
        }
    }

    private void validDuplicateNumber(String input) {
        List<Integer> inputNumbers = Arrays.stream(input.split(WINNING_NUMBER_INPUT_SPLIT_DELIMETER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (inputNumbers.size() != inputNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않은 숫자의 조합이어야 합니다");
        }
    }
}
