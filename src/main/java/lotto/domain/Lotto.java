package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_COUNT = 6;

    private final List<LottoNumber> values;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.values = new ArrayList<>(lottoNumbers);
        sort();
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoSet = new HashSet<>(lottoNumbers);
        if (lottoSet.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또번호가 6개가 아닙니다.");
        }
    }

    private void sort() {
        this.values.sort(Comparator.comparingInt(LottoNumber::getValue));
    }

    public List<LottoNumber> getValues() {
        return Collections.unmodifiableList(values);
    }

    public int matchCount(Lotto winningLotto) {
        return (int) values.stream()
                .filter(winningLotto.values::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return values.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(values, lotto.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }

}
