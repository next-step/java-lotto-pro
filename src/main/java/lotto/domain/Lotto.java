package lotto.domain;

import lotto.type.LottoRank;

import java.util.List;

public class Lotto {
    public static final String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);

        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank checkLottoRank(Lotto answerLotto) {
        return LottoRank.findLottoRankByMatchedCount(countMatchedNumber(answerLotto));
    }

    public int countMatchedNumber(Lotto answerLotto) {
        List<Integer> answerLottoNumbers = answerLotto.getLottoNumbers();

        return (int) lottoNumbers.stream()
                .filter(answerLottoNumbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
