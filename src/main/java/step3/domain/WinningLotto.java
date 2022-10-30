package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import step3.enums.Rule;

public class WinningLotto {

    private final LottoNumber winningNumber;

    int bonusNumber;

    public WinningLotto(String numbersWithComma, int bonusNumber) {

        this.winningNumber = new LottoNumber(gainWinnerNumbers(numbersWithComma));
        this.bonusNumber = bonusNumber;

    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoNumber getWinningNumber() {
        return winningNumber;
    }

    private List<Integer> gainWinnerNumbers(String numbersWithComma) {
        List<Integer> winnerNumbers = split(numbersWithComma);
        if (!isValidNumberWithRange(winnerNumbers)) {
            throw new IllegalArgumentException("잘 못된 숫자입니다.");
        }
        return winnerNumbers;
    }

    private List<Integer> split(String numbersWithComma) {
        return Arrays.asList(numbersWithComma.split(","))
                .stream()
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    }

    private boolean isValidNumberWithRange(List<Integer> winnerNumbers) {
        return winnerNumbers.stream()
                .filter(number -> Rule.TOTAL_START_NUMBER.getRange() <= number)
                .anyMatch(number -> number <= Rule.TOTAL_END_NUMBER.getRange());
    }

}
