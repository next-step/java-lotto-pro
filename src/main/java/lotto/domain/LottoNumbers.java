package lotto.domain;

import java.util.List;

import static java.util.Comparator.naturalOrder;

public class LottoNumbers {

    private static final String INVALID_NUMBER = "로또번호는 중복이되면 안됩니다.";
    private static final String INVALID_NUMBER_SIZE = "로또번호는 6자리여야 합니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateSize(lottoNumbers);
        lottoNumbers.sort(naturalOrder());
        this.lottoNumbers = lottoNumbers;
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream()
                .distinct()
                .count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        };
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
