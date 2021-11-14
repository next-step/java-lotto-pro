package step3.domain;

public class LottoWinningProfit {

  private final float profit;

  public LottoWinningProfit(float profit) {
    validate(profit);
    this.profit = profit;
  }

  public float getProfit() {
    return this.profit;
  }

  private void validate(float profit) {
    if (profit < 0) {
      throw new RuntimeException("[ERROR] winning price profit cannot be negative. profit =" + profit);
    }
  }
}
