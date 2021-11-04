package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = mapToLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("로또 숫자는 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != LOTTO_NUMBERS_SIZE;
    }

    private List<LottoNumber> mapToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
