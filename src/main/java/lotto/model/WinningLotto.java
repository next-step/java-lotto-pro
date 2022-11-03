package lotto.model;

public class WinningLotto {

  private static final String NUMBER_COMMA_REGEX = "[\\s0-9,]+";
  private static final String NUMBER_REGEX = "[0-9]+";
  private static final int LOTTO_SIZE = 6;
  private static final String ERROR_MESSAGE_BY_WRONG_WINNING_LOTTO_NUMBER_INPUT
      = "올바른 형식의 지난 당청 번호를 입력해주세요.";
  private static final String ERROR_MESSAGE_BY_WRONG_BONUS_NUMBER_INPUT
      = "올바른 형식의 보너스 볼을 입력해주세요.";
  private final Lotto lotto;
  private final LottoNumber bonusNumber;

  public WinningLotto(String winningLottoNumber, String bonusNumber) {
    this.lotto = generateWinningLotto(winningLottoNumber);
    this.bonusNumber = generateBonusNumber(bonusNumber);
    validDuplicateBonusNumber(this.lotto, this.bonusNumber);
  }

  private void validDuplicateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
    if (winningLotto.isContainNumber(bonusNumber)) {
      throw new IllegalArgumentException(ERROR_MESSAGE_BY_WRONG_BONUS_NUMBER_INPUT);
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
      throw new IllegalArgumentException(ERROR_MESSAGE_BY_WRONG_BONUS_NUMBER_INPUT);
    }
  }

  private void validLottoSize(String[] splitNumbers) {
    if (splitNumbers.length != LOTTO_SIZE) {
      throw new IllegalArgumentException(ERROR_MESSAGE_BY_WRONG_WINNING_LOTTO_NUMBER_INPUT);
    }
  }

  private void validWinningLottoNumber(String winningLottoNumber) {
    if (!winningLottoNumber.matches(NUMBER_COMMA_REGEX)) {
      throw new IllegalArgumentException(ERROR_MESSAGE_BY_WRONG_WINNING_LOTTO_NUMBER_INPUT);
    }
  }
}
