package lotto.domain;

import lotto.type.LottoRank;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<Integer> lottoNumbers) {
        if ((long) lottoNumbers.size() != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);

        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public LottoRank checkLottoRank(Lotto answerLotto) {
        return LottoRank.findLottoRankByMatchedCount(countMatchedNumber(answerLotto), false);
    }

    public int countMatchedNumber(Lotto answerLotto) {
        Set<Integer> answerLottoNumbers = answerLotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toSet());

        return (int) lottoNumbers.stream()
                .filter(number -> answerLottoNumbers.contains(number.getNumber()))
                .count();
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
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
