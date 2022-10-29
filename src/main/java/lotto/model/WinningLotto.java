package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.SplitUtil;

public class WinningLotto {

  private final Lotto winningLotto;

  public WinningLotto(String winningLottoNumber) {
    this.winningLotto = generateWinningLotto(winningLottoNumber);
  }

  private Lotto generateWinningLotto(String winningLottoNumber) {
    String[] splitNumbers = SplitUtil.splitInputNumbers(winningLottoNumber);

    List<Integer> nums = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt)
        .boxed().collect(Collectors.toList());

    return new Lotto(nums);
  }

  public Lotto getLotto() {
    return this.winningLotto;
  }

}
