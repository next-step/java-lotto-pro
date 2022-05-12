package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    protected Lotto(List<LottoNumber> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public static Lotto create(LottoNumberStrategy lottoNumberStrategy) {
        return new Lotto(lottoNumberStrategy.create());
    }

    public Rank match(Lotto winningLotto) {
        int matchCount = 0;
        Set<LottoNumber> collect = new HashSet<>(winningLotto.numbers);

        for (LottoNumber number : this.numbers) {
            if (collect.contains(number)) {
                matchCount++;
            }
        }

        return Rank.matchResult(matchCount);
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
