package lotto.model;

public class Counter {

  private static final int LOTTO_PRICE = 1000;

  public static int calculateLottoAmount(String input) {
    int purchasePrice = Integer.parseInt(input);

    int lottoAmount = purchasePrice / LOTTO_PRICE;

    return lottoAmount;

  }

}
