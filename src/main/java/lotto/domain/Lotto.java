package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import common.constant.ErrorCode;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;
    private static final int MATCH_LOTTO_NUMBER = 1;
    private static final int NOT_MATCH_LOTTO_NUMBER = 0;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto generateLotto(LottoNumberGenerator lottoNumberGenerator) {
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.generateLottoNumbers();
        return new Lotto(lottoNumbers);
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

    public int findLottoMatchCount(Lotto winningLotto) {
        int matchCount = 0;
        for(LottoNumber lottoNumber: this.lottoNumbers) {
            matchCount += findMatchLottoNumber(winningLotto, lottoNumber);
        }
        return matchCount;
    }

    private int findMatchLottoNumber(Lotto winningLotto, LottoNumber lottoNumber) {
        if(winningLotto.lottoNumbers.contains(lottoNumber)) {
            return MATCH_LOTTO_NUMBER;
        }
        return NOT_MATCH_LOTTO_NUMBER;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
