package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorCode;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLotto(List<LottoNumber> lottoNumbers) {
        validateDupliteLottoNumbers(lottoNumbers);
        validateLottoNumberCount(lottoNumbers);
    }

    private void validateDupliteLottoNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numbers = new HashSet<>(lottoNumbers);
        if(numbers.size() < lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorCode.로또의_각_숫자는_중복_불가.getErrorMessage());
        }
    }

    private void validateLottoNumberCount(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorCode.로또는_6개의_숫자로_이루어져야함.getErrorMessage());
        }
    }
}
