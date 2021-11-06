package lotto.domain.winstatistics;

import lotto.domain.winpolicy.Policy;
import lotto.domain.winpolicy.WinPolicy;

public class WinStatisticsInfo {
  private final WinPolicy winPolicy;
  private final Integer count;

  private WinStatisticsInfo(WinPolicy winPolicy) {
    this.winPolicy = winPolicy;
    this.count = 0;
  }

  private WinStatisticsInfo(WinPolicy winPolicy, Integer count) {
    this.winPolicy = winPolicy;
    this.count = count;
  }

  public static WinStatisticsInfo of(WinPolicy winPolicy) {
    return new WinStatisticsInfo(winPolicy);
  }

  public static WinStatisticsInfo of(WinPolicy winPolicy, Integer count) {
    return new WinStatisticsInfo(winPolicy, count);
  }

  public Integer getCount() {
    return this.count;
  }

  public Integer getWinPrice() {
    return this.winPolicy.getWinPrice();
  }

  public WinPolicy getWinPolicy() {
    return this.winPolicy;
  }
}
