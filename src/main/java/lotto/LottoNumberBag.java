package lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoNumberGenerator.LOTTO_NUMBER_SIZE;

public class LottoNumberBag implements NumberBag {

    private final List<Number> lottoNumbers;

    public LottoNumberBag(NumberGenerator numberGenerator) {
        this.lottoNumbers = numberGenerator.generate();
    }

    public LottoNumberBag(List<Number> numbers) {
        this.lottoNumbers = numbers;
    }

    public Score matchScore(WinningLottoBallBag winningLottoBallBag) {
        return winningLottoBallBag.matchScore(lottoNumbers);
    }

    @Override
    public List<Number> getNumbers() {
        validNumbers();
        return lottoNumbers;
    }

    private void validNumbers() {
        validNumberSize();
        validUnique();
        validRange();
    }

    private void validNumberSize() {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    "로또 숫자는 6개여야 합니다. 입력 값:" + lottoNumbers.stream()
                            .map(it -> String.valueOf(it.getIntNumber()))
                            .collect(Collectors.joining(",")));
        }
    }

    private void validUnique() {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException(
                    "로또 숫자는 중복되지 않은 값이어야 합니다. 입력 값:" + lottoNumbers.stream()
                            .map(it -> String.valueOf(it.getIntNumber()))
                            .collect(Collectors.joining(",")));
        }
    }

    private void validRange() {
        for (Number number : lottoNumbers) {
            number.validNumber();
        }
    }
}
