package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MAX_LOTTO_NUMBERS_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        validateRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복이 되면 안됩니다.");
        }
    }

    private void validateRange(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            validateNumberRange(lottoNumber);
        }
    }

    private void validateNumberRange(Integer lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 값이어야 합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
