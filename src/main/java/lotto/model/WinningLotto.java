package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.SplitUtil;

public class WinningLotto {

  private static final String NUMBER_COMMA_REGEX = "[\\s0-9,]+";
  private static final String NUMBER_REGEX = "[0-9]+";

  private static final int LOTTO_SIZE = 6;
  private static final int BONUS_NUMBER_SIZE = 1;
  private static final String ERROR_MESSAGE_BY_WRONG_WINNING_LOTTO_NUMBER_INPUT
      = "올바른 형식의 지난 당청 번호를 입력해주세요.";

  private static final String ERROR_MESSAGE_BY_WRONG_BONUS_NUMBER_INPUT
      = "올바른 형식의 보너스 볼을 입력해주세요.";

  private final Lotto lotto;
  private final int bonusNumber;

  public WinningLotto(String winningLottoNumber, String bonusNumber) {
    this.lotto = generateWinningLotto(winningLottoNumber);
    this.bonusNumber = generateBonusNumber(bonusNumber);
  }

  public Lotto getLotto() {
    return this.lotto;
  }

  public int getBonusNumber() {
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
    validWinningLottoNumber(winningLottoNumber);

    String[] splitNumbers = SplitUtil.splitInputNumbers(winningLottoNumber);

    validLottoSize(splitNumbers);

    List<Integer> nums = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt)
        .boxed().collect(Collectors.toList());

    return Lotto.createManualLotto(nums);
  }

  private int generateBonusNumber(String bonusNumber) {
    validBonusNumber(bonusNumber);
    String[] splitNumber = SplitUtil.splitInputNumbers(bonusNumber);
    validBonusNumberSize(splitNumber);
    return Integer.parseInt(splitNumber[0]);
  }

  private void validBonusNumber(String bonusNumber) {
    if (!bonusNumber.matches(NUMBER_REGEX)) {
      throw new IllegalArgumentException(ERROR_MESSAGE_BY_WRONG_BONUS_NUMBER_INPUT);
    }
  }

  private void validBonusNumberSize(String[] splitNumbers) {
    if (splitNumbers.length != BONUS_NUMBER_SIZE) {
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
