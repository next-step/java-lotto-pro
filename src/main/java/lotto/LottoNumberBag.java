package lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoNumberGenerator.LOTTO_NUMBER_SIZE;

public class LottoNumberBag implements NumberBag {

    private final List<Number> lottoNumbers;

    public LottoNumberBag(NumberGenerator numberGenerator) {
        this(numberGenerator.generate());
    }

    public LottoNumberBag(List<Number> numbers) {
        validNumbers(numbers);
        this.lottoNumbers = numbers;
    }

    public Score matchScore(WinningLottoBallBag winningLottoBallBag) {
        return winningLottoBallBag.matchScore(lottoNumbers);
    }

    @Override
    public List<Number> getNumbers() {
        return lottoNumbers;
    }

    private void validNumbers(List<Number> numbers) {
        validNumberSize(numbers);
        validUnique(numbers);
    }

    private void validNumberSize(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    "로또 숫자는 6개여야 합니다. 입력 값:" + numbers.stream()
                            .map(it -> String.valueOf(it.getIntNumber()))
                            .collect(Collectors.joining(",")));
        }
    }

    private void validUnique(List<Number> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(
                    "로또 숫자는 중복되지 않은 값이어야 합니다. 입력 값:" + numbers.stream()
                            .map(it -> String.valueOf(it.getIntNumber()))
                            .collect(Collectors.joining(",")));
        }
    }
}
