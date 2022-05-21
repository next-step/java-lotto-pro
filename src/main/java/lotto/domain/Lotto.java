package lotto.domain;

import lotto.type.LottoRank;

import java.util.ArrayList;
import java.util.Comparator;
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

    public void addBonusBallNumber(int bonusBallNumber) {
        if (lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber.getNumber() == bonusBallNumber))
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER);

        lottoNumbers.add(new LottoNumber(bonusBallNumber));
    }

    public LottoRank checkLottoRank(Lotto answerLotto) {
        final Set<Integer> numbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toSet());

        final Set<Integer> answerNumbers = answerLotto.getLottoNumbers().stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .map(LottoNumber::getNumber)
                .collect(Collectors.toSet());

        final int ballLottoNumberMatchedCount = countMatchedNumber(numbers, answerNumbers);

        boolean isMatchedBonusBall = isMatchedBonusBall(answerNumbers, numbers, ballLottoNumberMatchedCount == 5);

        return LottoRank.findLottoRankByMatchedCount(ballLottoNumberMatchedCount, isMatchedBonusBall);
    }

    public static int countMatchedNumber(Set<Integer> numbers, Set<Integer> answerNumbers) {
        return (int) answerNumbers.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .filter(answerNumber -> isContainNumber(answerNumber, numbers))
                .count();
    }

    private static boolean isContainNumber(Integer answerNumber, Set<Integer> numbers) {
        return numbers.contains(answerNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private boolean isMatchedBonusBall(Set<Integer> answerNumbers, Set<Integer> numbers, boolean isCheckedBonusBall) {
        boolean isMatchedBonusBall = false;

        if (isCheckedBonusBall) {
            Integer lastAnswerNumber = new ArrayList<>(answerNumbers).get(LOTTO_NUMBER_SIZE);
            isMatchedBonusBall = isContainNumber(lastAnswerNumber, numbers);
        }

        return isMatchedBonusBall;
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
