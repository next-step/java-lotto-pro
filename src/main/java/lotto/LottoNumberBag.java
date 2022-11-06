package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoNumberGenerator.LOTTO_NUMBER_SIZE;

public class LottoNumberBag implements NumberBag {

    private static final String SPLIT_DELIMITER = ",";

    private final List<Number> lottoNumbers;

    public LottoNumberBag(NumberGenerator numberGenerator) {
        this.lottoNumbers = numberGenerator.generate();
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
        // 정적 팩토리 메서드의 객체 생성을 위해 인자값을 물고다니는 구조 괜찮은가..?
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

    public static LottoNumberBag fromManualNumbers(String input) {
        return new LottoNumberBag(Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(it -> new LottoNumber(it.trim()))
                .collect(Collectors.toList()));
    }
}
