package lotto.model;

public class WinningLottoNumbers {
  private final LottoNumbers winningLottoNumbers;
  private final LottoNumber bonusNumber;

  public WinningLottoNumbers(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
    this.winningLottoNumbers = winningLottoNumbers;
    this.bonusNumber = bonusNumber;
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