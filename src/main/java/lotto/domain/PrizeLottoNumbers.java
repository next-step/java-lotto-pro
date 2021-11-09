package lotto.domain;

import lotto.exception.WrongLottoNumbersInputException;
import lotto.ui.LottoMessage;

import java.util.Objects;

public class PrizeLottoNumbers {

    private final LottoNumbers prizeLottoNumbers;
    private final LottoNumber bonusNumber;

    public PrizeLottoNumbers(String prizeLottoNumbers, int bonusNumber) {
        this(new LottoNumbers(prizeLottoNumbers), bonusNumber);
    }

    public PrizeLottoNumbers(LottoNumbers prizeLottoNumbers, int bonusNumber) {
        this.prizeLottoNumbers = prizeLottoNumbers;
        this.bonusNumber = new LottoNumber(bonusNumber);
        validateBonusNumberContains();
    }

    private void validateBonusNumberContains() {
        if (prizeLottoNumbers.containsNumber(bonusNumber)) {
            throw new WrongLottoNumbersInputException(LottoMessage.WRONG_BONUS_NUMBER_INPUT_MESSAGE);
        }
    }

    public LottoResult getLottoResult(LottoNumbers lottoNumbers) {
        int matchCount = lottoNumbers.getMatchCount(prizeLottoNumbers);
        boolean bonusMatch = lottoNumbers.containsNumber(this.bonusNumber);
        return new LottoResult(matchCount, bonusMatch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizeLottoNumbers that = (PrizeLottoNumbers) o;
        return Objects.equals(prizeLottoNumbers, that.prizeLottoNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeLottoNumbers, bonusNumber);
    }
}
