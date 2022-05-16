package lotto;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    public static final int SIZE = 6;
    private final List<LottoNumber> numbers;

    public WinningNumbers(String winningNumbers) {
        String[] split = winningNumbers.split(",");
        validateSize(split);
        this.numbers = mapLottoNumbers(split);
    }

    private List<LottoNumber> mapLottoNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(n -> new LottoNumber(Integer.parseInt(n.trim())))
                .collect(Collectors.toList());
    }

    private void validateSize(String[] numbers) {
        if (numbers.length != SIZE) {
            throw new IllegalArgumentException("당첨 번호는 " + SIZE + "개여야 합니다.");
        }
    }

    public boolean has(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(n -> n.equals(lottoNumber));
    }
}
