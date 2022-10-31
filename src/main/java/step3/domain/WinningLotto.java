package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import step3.enums.Rule;

public class WinningLotto {

    private final LottoNumbers winningNumber;

    int bonusNumber;

    public WinningLotto(String numbersWithComma, int bonusNumber) {
        this.winningNumber = gainWinnerNumbers(numbersWithComma);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoNumbers getWinningNumber() {
        return winningNumber;
    }

    private LottoNumbers gainWinnerNumbers(String numbersWithComma) {
        List<LottoNumber> winnerNumbers = split(numbersWithComma);
        if (!isValidNumberWithRange(new LottoNumbers(winnerNumbers))) {
            throw new IllegalArgumentException("잘 못된 숫자입니다.");
        }
        return new LottoNumbers(winnerNumbers);
    }

    private List<LottoNumber> split(String numbersWithComma) {
        return Arrays.asList(numbersWithComma.replace(" ", "").split(","))
                .stream()
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private boolean isValidNumberWithRange(LottoNumbers winnerNumbers) {
        return winnerNumbers.getLottoNumbers().stream()
                .filter(number -> Rule.TOTAL_START_NUMBER.getRange() <= number.getLottoNumber())
                .anyMatch(number -> number.getLottoNumber() <= Rule.TOTAL_END_NUMBER.getRange());
    }

}
