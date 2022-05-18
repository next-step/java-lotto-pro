package lotto.domain;

import lotto.type.LottoRank;

import java.util.Set;

public class Lotto {
    public static final String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final Set<Integer> lottoNumbers;

    public Lotto(Set<Integer> lottoNumbers) {
        if (lottoNumbers.stream().count() != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);

        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank checkLottoRank(Lotto answerLotto) {
        return LottoRank.findLottoRankByMatchedCount(countMatchedNumber(answerLotto));
    }

    public int countMatchedNumber(Lotto answerLotto) {
        Set<Integer> answerLottoNumbers = answerLotto.getLottoNumbers();

        return (int) lottoNumbers.stream()
                .filter(answerLottoNumbers::contains)
                .count();
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
