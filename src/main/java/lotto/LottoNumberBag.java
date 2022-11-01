package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoNumberGenerator.END_LOTTO_NUMBER_RANGE;
import static lotto.LottoNumberGenerator.LOTTO_NUMBER_SIZE;
import static lotto.LottoNumberGenerator.START_LOTTO_NUMBER_RANGE;

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
        validNumbers(this.lottoNumbers);
    }

    public int correctCount(LottoNumberBag winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }

    private void validNumbers(List<Integer> numbers) {
        validNumberSize(numbers);
        validUnique(numbers);
        validRange(numbers);
    }

    private void validInputNumber(String input) {
        try {
            Arrays.stream(input.split(WINNING_NUMBER_INPUT_SPLIT_DELIMETER))
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("당첨 번호는 모두 숫자여야 합니다. 입력 값:" + input);
        }
    }

    private void validNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    "로또 숫자는 6개여야 합니다. 입력 값:" + numbers.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
        }
    }

    private void validUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(
                    "로또 숫자는 중복되지 않은 값이어야 합니다. 입력 값:" + numbers.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
        }
    }

    private void validRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkRange(number);
        }
    }

    private void checkRange(int number) {
        if (number < START_LOTTO_NUMBER_RANGE || END_LOTTO_NUMBER_RANGE < number) {
            throw new IllegalArgumentException(
                    "로또 숫자는 1 ~ 45 사이의 값이어야 합니다. 입력 값:" + number);
        }
    }
}
