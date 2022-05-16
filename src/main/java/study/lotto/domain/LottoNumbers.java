package study.lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    static final int LOTTO_NUMBER_SIZE = 6;
    static final String TO_STRING_DELIMITER = ", ";

    private final List<LottoNumber> value;

    public LottoNumbers(List<Integer> numbers) {
        checkLottoNumberSize(numbers);
        checkDuplicates(numbers);
        value = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<Integer> match(LottoNumbers lottoNumbers) {
        List<Integer> duplicates = new ArrayList<>(numbers());
        duplicates.retainAll(lottoNumbers.numbers());
        return duplicates;
    }

    public boolean has(int number) {
        return value.stream()
                .anyMatch(lottoNumber -> lottoNumber.hasNumber(number));
    }

    public List<Integer> numbers() {
        return value.stream()
                .map(LottoNumber::toString)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void checkLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(numbers);
        if (lottoNumberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 로또 번호를 가질 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return String.join(TO_STRING_DELIMITER,
                value.stream()
                        .map(LottoNumber::toString)
                        .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
