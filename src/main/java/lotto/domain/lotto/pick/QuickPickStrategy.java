package lotto.domain.lotto.pick;

import static lotto.utils.Validations.requireNotNull;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.RandomNumberGenerator;

public class QuickPickStrategy implements NumberPickStrategy {
    private final RandomNumberGenerator randomNumberGenerator;

    public QuickPickStrategy(RandomNumberGenerator randomNumberGenerator) {
        requireNotNull(randomNumberGenerator, "숫자 생성기는 null이 아니어야 합니다.");
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public Stream<LottoNumbers> pickNumbers(final int quantity) {
        return Stream.generate(this::generateNumbers)
                .limit(quantity)
                .map(LottoNumbers::new);
    }

    private List<Integer> generateNumbers() {
        final List<Integer> numbers = randomNumberGenerator.generate();

        checkNumbersSize(numbers);

        return numbers;
    }

    private void checkNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LottoNumbers.SIZE) {
            throw new IllegalStateException("생성된 숫자의 길이가 " + LottoNumbers.SIZE + "이어야 합니다. elements=" + numbers);
        }
    }
}
