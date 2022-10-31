package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.SplitUtil;

public class WinningLotto {
  private static final String NUMBER_REGEX = "[\\s0-9,]+";
  private static final String WINNING_LOTTO_INPUT_ERROR_MESSAGE
      = "올바른 형식의 지난 당청 번호를 입력해주세요.";

  private final Lotto lotto;

  public WinningLotto(String winningLottoNumber) {
    this.lotto = generateWinningLotto(winningLottoNumber);
  }

  private Lotto generateWinningLotto(String winningLottoNumber) {
    validWinningLottoNumber(winningLottoNumber);

    String[] splitNumbers = SplitUtil.splitInputNumbers(winningLottoNumber);

    validSplitNumbersSize(splitNumbers);

    List<Integer> nums = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt)
        .boxed().collect(Collectors.toList());

    return Lotto.createManualLotto(nums);
  }

  private void validSplitNumbersSize(String[] splitNumbers) {
    if(splitNumbers.length != 6) {
      throw new IllegalArgumentException(WINNING_LOTTO_INPUT_ERROR_MESSAGE);
    }
  }

  private void validWinningLottoNumber(String winningLottoNumber) {
    if(!winningLottoNumber.matches(NUMBER_REGEX)) {
      throw new IllegalArgumentException(WINNING_LOTTO_INPUT_ERROR_MESSAGE);
    }
  }

  public Lotto getLotto() {
    return this.lotto;
  }

}
