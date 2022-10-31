package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickPickStrategy implements NumberPickStrategy {
    private final RandomNumberGenerator randomNumberGenerator;

    public QuickPickStrategy(RandomNumberGenerator randomNumberGenerator) {
        if (Objects.isNull(randomNumberGenerator)) {
            throw new IllegalArgumentException("숫자 생성기는 null이 아니어야 합니다.");
        }
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public List<Lotto> pickNumbers(final int quantity) {
        return Stream.generate(this::generateNumbers)
                .map(Lotto::new)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    private List<Integer> generateNumbers() {
        final List<Integer> numbers = randomNumberGenerator.generate();

        checkNumbersSize(numbers);

        return numbers;
    }

    private void checkNumbersSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.LOTTO_NUMBERS_SIZE) {
            throw new IllegalStateException("생성된 숫자의 길이가 " + Lotto.LOTTO_NUMBERS_SIZE + "이어야 합니다. elements=" + numbers);
        }
    }
}
