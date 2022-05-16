package lotto.domain;

import java.util.List;

import static lotto.common.Messages.LOTTO_NUMBERS_DUPLICATE;
import static lotto.common.Messages.LOTTO_NUMBERS_SIZE;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_MAX_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumbersSize(lottoNumbers);
        validateDuplicateNumber(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int containsCount(LottoNumbers lastWeekWinningNumber) {
        return (int) lastWeekWinningNumber.getLottoNumbers()
                .stream()
                .filter(this::isContainsLottoNumber)
                .count();
    }

    public boolean containsBonusBall(BonusBall bonusBall) {
        return isContainsLottoNumber(bonusBall.getBonusBall());
    }

    private boolean isContainsLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private void validateLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() > LOTTO_NUMBERS_MAX_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE);
        }
    }

    private void validateDuplicateNumber(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() < LOTTO_NUMBERS_MAX_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE);
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
