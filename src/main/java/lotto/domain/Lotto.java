package lotto.domain;

import lotto.type.LottoRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final String ERROR_NON_UNIQUE_LOTTO_BONUS_BALL_BALL = "[ERROR] 2등 보너스볼 번호가 로또번호와 중복됩니다.";
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.checkMainLottoNumbersSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(List<Integer> lottoNumbers, Integer number) {
        this.checkMainLottoNumbersSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        addBonusNumber(number);
    }

    private void checkMainLottoNumbersSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);
    }

    private void addBonusNumber(Integer number) {
        if (isOverlapBonusBallNumber(number))
            throw new IllegalArgumentException(ERROR_NON_UNIQUE_LOTTO_BONUS_BALL_BALL);
        this.lottoNumbers.add(number);
    }

    public boolean isOverlapBonusBallNumber(int number) {
        return this.lottoNumbers.contains(number);
    }

    public LottoRank checkLottoRank(Lotto answerLotto) {
        List<Integer> d = Arrays.stream(LottoRank.values())
                .map(LottoRank::getMatchedCount)
                .collect(Collectors.toList());

        int lastIndex = answerLotto.getLottoNumbers().size() - 1;
        int bonusLottoNumber = lottoNumbers.get(lastIndex);

        LottoRank lottoRank = LottoRank.findLottoRankByMatchedCount(countMatchedNumber(answerLotto), false);
        return lottoRank;
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
