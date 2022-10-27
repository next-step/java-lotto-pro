package step3.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        return new Lotto(numbers);
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자가 필수적으로 입력되어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public long getNumberCountContainsBy(Lotto winLotto) {
        return numbers.stream()
                .filter(winLotto.getNumbers()::contains)
                .count();
    }
}
