package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.common.ErrorMessage;

public class Lotto {
    private static final int MAX_LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this(LottoNumbers.generateLottoNumbers());
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_ERROR.getErrorMessage());
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorMessage());
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int matchCounts(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(number -> lotto.getLottoNumbers().contains(number))
                .count();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return String.valueOf(lottoNumbers);
    }
}
