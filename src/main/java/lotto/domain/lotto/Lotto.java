package lotto.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.message.ErrorMessages;

public class Lotto {
    private static final int MATCH = 1;
    private static final int NOT_MATCH = 0;
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        validateNonDuplicatedNumbers(lottoNumbers);
        validateSixNumbers(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static void validateNonDuplicatedNumbers(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(String.format(ErrorMessages.DUPLICATED_LOTTO_NUMBERS, lottoNumbers));
        }
    }

    private static void validateSixNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(ErrorMessages.INVALID_LOTTO_NUMBERS_COUNT, lottoNumbers));
        }
    }

    public int matches(List<LottoNumber> winningNumbers) {
        int matches = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            matches += matchCount(winningNumbers, lottoNumber);
        }
        return matches;
    }

    private int matchCount(List<LottoNumber> winningNumbers, LottoNumber lottoNumber) {
        if (winningNumbers.contains(lottoNumber)) {
            return MATCH;
        }
        return NOT_MATCH;
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
