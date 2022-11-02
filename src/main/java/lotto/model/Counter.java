package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.SplitUtil;

public class Counter {

  public static final int LOTTO_PRICE = 1000;
  private static final String NUMBER_REGEX = "[0-9]+";
  private static final String COUNTER_ERROR_MESSAGE = "[COUNTER_ERROR] 올바른 금액을 입력해주세요.";

  private final LottoList lottoList;

  public Counter(String inputMoney) {
    this.lottoList = buyLotto(inputMoney);
  }

  public Counter(String inputMoney, List<String> manualNumbers) {
    this.lottoList = buyLotto(inputMoney, manualNumbers);
  }


  private static void validNumber(String input) {
    if (isNumber(input)) {
      throw new IllegalArgumentException(COUNTER_ERROR_MESSAGE);
    }
  }

  private static boolean isNumber(String input) {
    return !input.matches(NUMBER_REGEX);
  }

  public LottoList getLottoList() {
    return this.lottoList;
  }

  public LottoList buyLotto(String inputMoney) {
    validInputMoney(inputMoney);

    int lottoAmount = calculateLottoAmount(inputMoney);

    return lottoList;
  }

  private LottoList buyManualLotto(String manualNumber) {

    return null;
  }

  public LottoList buyLotto(String inputMoney, List<String> manualNumbers) {
    validInputMoney(inputMoney);

    List<String[]> test = manualNumbers.stream()
        .map(manualNumber -> SplitUtil.splitInputNumbers(manualNumber))
        .collect(Collectors.toList());

    List<List<Integer>> test2 = test.stream()
        .map(i ->
            Arrays.stream(i)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList())
        ).collect(Collectors.toList());

    int lottoAmount = calculateLottoAmount(inputMoney);

    LottoList lottoList = new LottoList(lottoAmount);

    return lottoList;
  }

  private int calculateLottoAmount(String input) {
    int purchasePrice = Integer.parseInt(input);

    int lottoAmount = purchasePrice / LOTTO_PRICE;

    return lottoAmount;
  }

  private void validInputMoney(String inputMoney) {
    validNullOrEmpty(inputMoney);
    validNumber(inputMoney);
    validUnderLottoPrice(inputMoney);
  }

  private void validUnderLottoPrice(String input) {
    if (isUnderLottoPrice(input)) {
      throw new IllegalArgumentException(COUNTER_ERROR_MESSAGE);
    }
  }

  private boolean isUnderLottoPrice(String input) {
    return Integer.parseInt(input) < LOTTO_PRICE;
  }

  private void validNullOrEmpty(String input) {
    if (isNullOrEmpty(input)) {
      throw new IllegalArgumentException(COUNTER_ERROR_MESSAGE);
    }
  }

  private boolean isNullOrEmpty(String input) {
    return input == null || input.isEmpty();
  }

}
