package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class LottoNumbers {

    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final String INVALID_NUMBER = "로또번호는 중복이되면 안됩니다.";
    private static final String INVALID_NUMBER_SIZE = "로또번호는 6자리여야 합니다.";
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateSize(lottoNumbers);
        lottoNumbers.sort(naturalOrder());
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

    public LottoRank compareWinningNumbers(LottoNumbers lottoWinningNumbers) {
        return LottoRank.from(calculateMatchCount(lottoWinningNumbers));
    }

    private int calculateMatchCount(LottoNumbers lottoWinningNumbers) {
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
