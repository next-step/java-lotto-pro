package lotto.domain.winstatistics;

public class RevenueRatio {
  private static final String REVENUE_RATIO_DISPLAY_FORMAT = "%.2f";
  
  private final String value;

  public RevenueRatio(String value) {
    this.value = value;
  }

  public static RevenueRatio of(Integer totalWinPrice, Integer totalBuyLottoPrice) {
    return new RevenueRatio(String.format(REVENUE_RATIO_DISPLAY_FORMAT, (float)totalWinPrice / totalBuyLottoPrice));
  }

  public String getValue() {
    return value;
  }
}
