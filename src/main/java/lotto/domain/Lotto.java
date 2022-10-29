package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    @Override
    public String toString() {
        String joinedLottoNumbers = numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(","));

        return String.format("[%s]", joinedLottoNumbers);
    }

    public int compareMatchCount(Lotto winningLotto) {
        long count = numbers.stream()
                .filter(winningLotto::hasSameNumber)
                .count();
        return (int) count;
    }

    private boolean hasSameNumber(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }
}
