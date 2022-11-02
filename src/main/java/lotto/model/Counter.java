package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Counter {

  public static final int LOTTO_PRICE = 1000;
  private static final String NUMBER_REGEX = "[0-9]+";
  private static final String COUNTER_ERROR_MESSAGE = "[COUNTER_ERROR] 올바른 금액을 입력해주세요.";

  private final LottoList lottoList;

  private final String inputMoney;
  private final int manualLottoAmount;
  private final int autoLottoAmount;

  public Counter(String inputMoney, List<String> manualNumbers) {
    this.lottoList = buyLotto(inputMoney, manualNumbers);
    this.inputMoney = inputMoney;
    this.manualLottoAmount = manualNumbers.size();
    this.autoLottoAmount = lottoList.getLottoList().size() - manualLottoAmount;
  }

  private static void validNumber(String input) {
    if (isNumber(input)) {
      throw new IllegalArgumentException(COUNTER_ERROR_MESSAGE);
    }
  }

  private static boolean isNumber(String input) {
    return !input.matches(NUMBER_REGEX);
  }

  public int getAutoLottoAmount() {
    return autoLottoAmount;
  }

  public LottoList getLottoList() {
    return this.lottoList;
  }

  public String getInputMoney() {
    return inputMoney;
  }

  public int getManualLottoAmount() {
    return manualLottoAmount;
  }

  public LottoList buyLotto(String inputMoney, List<String> manualNumbers) {
    validInputMoney(inputMoney);

    int lottoAmount = calculateLottoAmount(inputMoney);

    List<Lotto> lottos = manualNumbers.stream()
        .map(manualNumber -> Lotto.createManualLotto(manualNumber)).collect(
            Collectors.toList());

    LottoList lottoList = new LottoList(lottos);
    int manualLottoAmount = lottoList.getLottoList().size();
    LottoList lottoListByAuto = new LottoList(lottoAmount - manualLottoAmount);

    lottoList.getLottoList().addAll(lottoListByAuto.getLottoList());

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
