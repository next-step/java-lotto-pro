package step3;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final int COUNT_LOTTO_NUMBER = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    final Set<Integer> lotto;

    public Lotto(List<Integer> inputNumbers) {
        this.lotto = new HashSet<>(inputNumbers);
        validate();
    }

    private void validate() {
        if (isInvalidNumberCount()) {
            throw new IllegalArgumentException("중복되지 않은 6개의 숫자를 입력해주세요.");
        }
        if (isInvalidNumberInRange()) {
            throw new IllegalArgumentException("1~45의 숫자만 입력해주세요.");
        }
    }

    private boolean isInvalidNumberInRange() {
        return lotto.stream()
                .anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER);
    }

    private boolean isInvalidNumberCount() {
        return lotto.size() != COUNT_LOTTO_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return lotto != null ? lotto.hashCode() : 0;
    }
}
