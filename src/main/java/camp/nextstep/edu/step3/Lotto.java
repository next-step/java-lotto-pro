package camp.nextstep.edu.step3;

import java.util.*;

public class Lotto {
    private static final int VALID_SIZE = 6;
    private final Set<LottoNumber> numbers = new TreeSet<>();

    public Lotto(final List<LottoNumber> numbers) {
        this(new HashSet<>(numbers));
    }

    public Lotto(final Set<LottoNumber> numbers) {
        validationSize(numbers);
        this.numbers.addAll(numbers);
    }

    public Hit checkTo(final Lotto prizeLotto) {
        return Hit.valueOf(prizeLotto.checkBy(this.numbers), false);
    }

    private void validationSize(Set<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty() || lottoNumbers.size() < VALID_SIZE) {
            throw new IllegalArgumentException("invalid LottoNumbers");
        }
    }

    private int checkBy(Set<LottoNumber> userLottoNumbers) {
        return Long.valueOf(userLottoNumbers.stream()
                .filter(this.numbers::contains)
                .count())
                .intValue();
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
        return numbers.toString();
    }
}
