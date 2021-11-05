package lotto.domain.winstatistics;

public class RevenueRatio {
  private final String value;

  public RevenueRatio(String value) {
    this.value = value;
  }

  public static RevenueRatio of(Integer totalWinPrice, Integer totalBuyLottoPrice) {
    return new RevenueRatio(String.format("%.2f", (float)totalWinPrice / totalBuyLottoPrice));
  }

  public String getValue() {
    return value;
  }
}
