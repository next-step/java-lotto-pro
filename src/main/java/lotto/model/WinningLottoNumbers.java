package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.InvalidInputException;

public class WinningLottoNumbers {
  private final LottoNumbers winningLottoNumbers;
  private final LottoNumber bonusNumber;

  public WinningLottoNumbers(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
    checkBonusNumberValidation(winningLottoNumbers, bonusNumber);

    this.winningLottoNumbers = winningLottoNumbers;
    this.bonusNumber = bonusNumber;
  }

  private void checkBonusNumberValidation(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
    if (winningLottoNumbers.hasBonusNumber(bonusNumber)) {
      throw new InvalidInputException(ErrorMessage.INVALID_BONUS_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }

  public LottoRank getRankCompareTo(LottoNumbers compareLottoNumbers) {
    int matchCount = compareLottoNumbers.countNumberOfMatches(winningLottoNumbers);
    boolean matchBonus = compareLottoNumbers.hasBonusNumber(bonusNumber);

    return LottoRank.valueOf(matchCount, matchBonus);
  }

  public LottoNumbers getWinningLottoNumbers() {
    return winningLottoNumbers;
  }

  public LottoNumber getBonusNumber() {
    return bonusNumber;
  }

}