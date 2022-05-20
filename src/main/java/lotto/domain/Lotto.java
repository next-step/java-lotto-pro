package lotto.domain;

import lotto.type.LottoRank;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 6개의 숫자를 입력해주세요.";
    public static final String ERROR_BONUS_NUMBER = "[ERROR] 중복없이 6개의 숫자와 보너스볼 숫자를 입력해주세요.";
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<Integer> lottoNumbers) {
        checkValidationLottoNumberSize(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private void checkValidationLottoNumberSize(Set<Integer> lottoNumbers) {
        if ((long) lottoNumbers.size() != LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);
    }

    public Set<Integer> addBonusBallNumber(Set<Integer> answerLottoNumbers, int bonusBallNumber) {
        answerLottoNumbers.add(bonusBallNumber);

        if (answerLottoNumbers.size() != 7)
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER);

        return answerLottoNumbers;
    }

    public LottoRank checkLottoRank(Lotto answerLotto) {
        final Set<Integer> answerLottoNumbers = answerLotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toSet());

        final int ballLottoNumberMatchedCount = countMatchedNumber(answerLottoNumbers);
        final boolean isCheckedBonusBall = ballLottoNumberMatchedCount == 5;

        boolean isMatchedBonusBall = false;
        if (isCheckedBonusBall) {
            LottoNumber lastAnswerLottoNumber = new ArrayList<>(lottoNumbers).get(LOTTO_NUMBER_SIZE);
            isMatchedBonusBall = isCheck(lastAnswerLottoNumber, answerLottoNumbers);
        }

        return LottoRank.findLottoRankByMatchedCount(ballLottoNumberMatchedCount, isMatchedBonusBall);
    }

    public int countMatchedNumber(Set<Integer> answerLottoNumbers) {
        return (int) lottoNumbers.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .filter(lottoNumber -> isCheck(lottoNumber, answerLottoNumbers))
                .count();
    }

    private boolean isCheck(LottoNumber lottoNumber, Set<Integer> answerLottoNumbers) {
        return answerLottoNumbers.contains(lottoNumber.getNumber());
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
