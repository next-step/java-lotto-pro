package lotto.view;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private static final String NUMBER_FORMAT_REGEX = "^[0-9]+$";
    private static final Scanner scanner = new Scanner(System.in);

    public int getUserInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseInputStringToInteger(scanner.next());
    }

    public List<Number> getUserInputMatchNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseInputStringToNumberList(scanner.next());
    }

    private int parseInputStringToInteger(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        validateNumberFormat(inputString);
        return Integer.parseInt(inputString);
    }

    private List<Number> parseInputStringToNumberList(String inputString) {
        List<Number> result = new ArrayList<>();
        for (String number : inputString.split(SPLIT_REGEX)) {
            validateNumberFormat(number);
            result.add(new Number(Integer.parseInt(number)));
        }
        return result;
    }

    private void validateNumberFormat(String inputString) {
        boolean matches = inputString.matches(NUMBER_FORMAT_REGEX);
        if (!matches) {
            throw new NumberFormatException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }

}
