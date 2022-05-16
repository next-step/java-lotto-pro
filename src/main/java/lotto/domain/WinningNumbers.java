package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNumber> numbers;

    public WinningNumbers(String winningNumbers) {
        List<String> trimmedWinningNumberList = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        validateSize(trimmedWinningNumberList);
        List<LottoNumber> winningLottoNumbers = mapLottoNumbers(trimmedWinningNumberList);
        validateDuplicate(winningLottoNumbers);
        this.numbers = winningLottoNumbers;
    }

    private List<LottoNumber> mapLottoNumbers(List<String> numbers) {
        return numbers.stream()
                .map(n -> new LottoNumber(n))
                .collect(Collectors.toList());
    }

    private void validateSize(List<String> numbers) {
        if (numbers.size() != LottoGame.SIZE) {
            throw new IllegalArgumentException("당첨 번호는 " + LottoGame.SIZE + "개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        HashSet<LottoNumber> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != LottoGame.SIZE) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public boolean has(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(n -> n.equals(lottoNumber));
    }
}
