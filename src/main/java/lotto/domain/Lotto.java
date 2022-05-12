package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    protected Lotto(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    public static Lotto create(LottoNumberStrategy lottoNumberStrategy) {
        return new Lotto(lottoNumberStrategy.create());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
