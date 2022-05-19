package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        sort();
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoSet = new HashSet<>(lottoNumbers);
        if (lottoSet.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또번호가 6개가 아닙니다.");
        }
    }

    private void sort() {
        this.lottoNumbers
                .sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int matchCount(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto.lottoNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
