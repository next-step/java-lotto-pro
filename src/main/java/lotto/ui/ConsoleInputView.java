package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    @Override
    public int takeBudget() {
        System.out.println("구매금액을 입력해주세요.");
        String budget = Console.readLine();
        try {
            return Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매금액은 숫자만 입력가능합니다.");
        }
    }

    @Override
    public List<Integer> takeWinMainNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return takeNumbers();
    }

    private List<Integer> takeNumbers() {
        String input = Console.readLine();
        String[] inputNumbers = input.split(",");
        return Arrays.stream(inputNumbers)
                .mapToInt((number) -> Integer.parseInt(number.trim()))
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public int takeBonusNumbers() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    @Override
    public int takeManualBuyCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    @Override
    public List<Integer> takeManualLottoNumbers() {
        return takeNumbers();
    }

    @Override
    public void printManualLottoNumbersHeader() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
}
