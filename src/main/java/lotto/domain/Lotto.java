package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(Collection<LottoNumber> numbers) {
        validationSize(numbers);
        validationDuplicate(numbers);

        this.numbers = new ArrayList<>(numbers);
    }

    public int matche(Lotto lotto) {
        return (int) numbers.stream().map(lotto::contains).filter(Boolean::booleanValue).count();
    }

    public List<LottoNumber> numbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;

        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    private void validationSize(Collection<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 6개여야 합니다. (lottoNumbers: %s)", numbers.size()));
        }
    }

    private void validationDuplicate(Collection<LottoNumber> numbers) {
        long deduplicatedCount = numbers.stream().distinct().count();
        if (deduplicatedCount != numbers.size()) {
            throw new IllegalArgumentException(String.format("로또 번호는 중복될 수 없습니다. (lottoNumbers: %s)", numbers));
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }
}
