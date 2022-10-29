package lotto.model;

public class Counter {

  public static final int LOTTO_PRICE = 1000;

  public static LottoList buyLotto(String input) {
    int lottoAmount = calculateLottoAmount(input);

    LottoList lottoList = new LottoList(lottoAmount);

    return lottoList;
  }

  private static int calculateLottoAmount(String input) {
    int purchasePrice = Integer.parseInt(input);

    int lottoAmount = purchasePrice / LOTTO_PRICE;

    return lottoAmount;

  }

}
