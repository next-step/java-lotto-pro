package lotto.model;

public class Counter {

  private static final int LOTTO_PRICE = 1000;

  public static int buyLotto(int input) {
    int lottoCount = input / LOTTO_PRICE;

    return lottoCount;
  }

}
