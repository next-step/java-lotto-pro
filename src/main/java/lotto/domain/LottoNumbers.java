package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.naturalOrder;

public class LottoNumbers {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String INVALID_BETWEEN_MIN_AND_MAX = "당첨 번호는 1 ~ 45 중에서 골라주세요.";
    private static final String INVALID_NUMBER = "로또번호는 중복이되면 안됩니다.";
    private static final String INVALID_NUMBER_SIZE = "로또번호는 6자리여야 합니다.";
    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateSize(lottoNumbers);
        validateBetweenMinAndMax(lottoNumbers);
        lottoNumbers.sort(naturalOrder());
        this.lottoNumbers = Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank compareWinningNumbers(LottoNumbers lottoWinningNumbers) {
        return LottoRank.from(getMatchCount(lottoWinningNumbers));
    }

    private int getMatchCount(LottoNumbers lottoWinningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> lottoWinningNumbers.getLottoNumbers()
                        .stream()
                        .anyMatch(Predicate.isEqual(lottoNumber)))
                .count();
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream()
                .distinct()
                .count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
        }
    }

    private void validateBetweenMinAndMax(List<Integer> splitWinningNumbers) {
        if (!splitWinningNumbers.stream()
                .allMatch(LottoNumbers::isBetweenMinAndMax)) {
            throw new IllegalArgumentException(INVALID_BETWEEN_MIN_AND_MAX);
        }
    }

    private static boolean isBetweenMinAndMax(int prizeNumber) {
        return (prizeNumber >= MIN_LOTTO_NUMBER) && (prizeNumber <= MAX_LOTTO_NUMBER);
    }

}
