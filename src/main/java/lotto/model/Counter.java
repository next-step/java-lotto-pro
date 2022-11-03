package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorCode;
import lotto.exception.LottoException;

public class Counter {

  public static final int LOTTO_PRICE = 1000;
  private static final String NUMBER_REGEX = "[0-9]+";
  private final String inputMoney;
  private LottoList lottoList;
  private int manualLottoAmount;
  private int autoLottoAmount;

  public Counter(String inputMoney) {
    validInputMoney(inputMoney);
    this.lottoList = null;
    this.inputMoney = inputMoney;
    this.manualLottoAmount = 0;
    this.autoLottoAmount = 0;
  }

  private static void validNumber(String input) {
    if (isNumber(input)) {
      throw new LottoException(ErrorCode.INVALID_INPUT_NUMBER_ERROR);
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

  public void issueLotto(List<String> manualNumbers) {
    int lottoAmount = calculateLottoAmount(inputMoney);

    this.manualLottoAmount = manualNumbers.size();
    this.autoLottoAmount = lottoAmount - manualLottoAmount;

    List<Lotto> lottos = manualNumbers.stream()
        .map(manualNumber -> Lotto.createManualLotto(manualNumber)).collect(
            Collectors.toList());

    LottoList lottoList = new LottoList(lottos);
    LottoList lottoListByAuto = new LottoList(autoLottoAmount);

    lottoList.getLottoList().addAll(lottoListByAuto.getLottoList());

    this.lottoList = lottoList;
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
      throw new LottoException(ErrorCode.UNDER_LOTTO_PRICE_ERROR);
    }
  }

  private boolean isUnderLottoPrice(String input) {
    return Integer.parseInt(input) < LOTTO_PRICE;
  }

  private void validNullOrEmpty(String input) {
    if (isNullOrEmpty(input)) {
      throw new LottoException(ErrorCode.INVALID_INPUT_NULL_VALUE_ERROR);
    }
  }

  private boolean isNullOrEmpty(String input) {
    return input == null || input.isEmpty();
  }

}
