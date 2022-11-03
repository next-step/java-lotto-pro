package lotto.model;

import lotto.exception.ErrorCode;
import lotto.exception.LottoException;

public class WinningLotto {

  private static final String NUMBER_REGEX = "[0-9]+";

  private final Lotto lotto;
  private final LottoNumber bonusNumber;

  public WinningLotto(String winningLottoNumber, String bonusNumber) {
    this.lotto = generateWinningLotto(winningLottoNumber);
    this.bonusNumber = generateBonusNumber(bonusNumber);
    validDuplicateBonusNumber(this.lotto, this.bonusNumber);
  }

  private void validDuplicateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
    if (winningLotto.isContainNumber(bonusNumber)) {
      throw new LottoException(ErrorCode.BONUS_NUMBER_DUPLICATE_ERROR);
    }
  }

  public Lotto getLotto() {
    return this.lotto;
  }

  public LottoNumber getBonusNumber() {
    return this.bonusNumber;
  }

  public LottoRank getLottoRankByLotto(Lotto lotto) {
    LottoRank lottoRank = LottoRank.getLottoRank(
        lotto.getMatchingCount(this.lotto),
        lotto.isContainNumber(this.bonusNumber)
    );

    return lottoRank;
  }

  private Lotto generateWinningLotto(String winningLottoNumber) {
    return Lotto.createManualLotto(winningLottoNumber);
  }

  private LottoNumber generateBonusNumber(String bonusNumber) {
    validBonusNumber(bonusNumber);
    return LottoNumber.from(bonusNumber);
  }

  private void validBonusNumber(String bonusNumber) {
    if (!bonusNumber.matches(NUMBER_REGEX)) {
      throw new LottoException(ErrorCode.INVALID_INPUT_NUMBER_ERROR);
    }
  }
}
