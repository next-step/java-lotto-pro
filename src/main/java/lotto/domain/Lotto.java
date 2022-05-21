package lotto.domain;

import lotto.type.LottoRank;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 6개의 숫자를 입력해주세요.";
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

    public LottoRank checkLottoRank(Lotto answerLotto, LottoNumber bonusLottoNumber) {
        final Set<Integer> numbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toSet());

        final Set<Integer> answerNumbers = answerLotto.getLottoNumbers().stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .map(LottoNumber::getNumber)
                .collect(Collectors.toSet());

        final int ballLottoNumberMatchedCount = countMatchedNumber(numbers, answerNumbers);

        return LottoRank.findLottoRankByMatchedCount(ballLottoNumberMatchedCount, numbers.contains(bonusLottoNumber.getNumber()));
    }

    public static int countMatchedNumber(Set<Integer> numbers, Set<Integer> answerNumbers) {
        return (int) answerNumbers.stream()
                .filter(answerNumber -> isContainNumber(answerNumber, numbers))
                .count();
    }

    private static boolean isContainNumber(Integer answerNumber, Set<Integer> numbers) {
        return numbers.contains(answerNumber);
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
