package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoNumberValidator.validInputNumber;
import static lotto.LottoNumberValidator.validNumbers;

public class LottoNumberBag {

    private final List<Integer> lottoNumbers;

    public static final String WINNING_NUMBER_INPUT_SPLIT_DELIMETER = ", |,";

    public LottoNumberBag(NumberGenerator numberGenerator) {
        this.lottoNumbers = numberGenerator.generate();
    }

    public LottoNumberBag(List<Integer> numbers) {
        validNumbers(numbers);
        lottoNumbers = numbers;
    }

    public LottoNumberBag(String lottoNumbers) {
        validInputNumber(lottoNumbers);
        this.lottoNumbers = Arrays.stream(lottoNumbers.split(WINNING_NUMBER_INPUT_SPLIT_DELIMETER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int correctCount(LottoNumberBag winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
