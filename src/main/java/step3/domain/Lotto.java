package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int SIZE = 6;

    private final Set<LottoNumber> lotto;

    Lotto(List<Integer> numbers) {
        Set<LottoNumber> numberSet = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        validate(numberSet);
        this.lotto = numberSet;
    }

    private void validate(Set<LottoNumber> numberSet) {
        if (numberSet.size() != SIZE) {
            throw new IllegalArgumentException(String.format("중복되지 않은 %d개의 숫자를 입력해주세요.", SIZE));
        }
    }

    public int match(WinnerLotto winnerLotto) {
        return (int) winnerLotto.lottoNumbers().stream()
                .filter(lotto::contains)
                .count();
    }

    public List<LottoNumber> sortedLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
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

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
