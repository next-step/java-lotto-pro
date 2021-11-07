package lotto.domain.winstatistics;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.winpolicy.WinPolicy;

public class WinStatisticsInfos {
  private final List<WinStatisticsInfo> statisticsInfos;

  public WinStatisticsInfos() {
    this.statisticsInfos = new ArrayList<>();
  }

  public boolean add(WinStatisticsInfo value) {
    return this.statisticsInfos.add(value);
  }

  public WinStatisticsInfo findBy(WinPolicy winPolicy) {
    return this.statisticsInfos.stream()
                                .filter(item -> item.getWinPolicy().equals(winPolicy))
                                .findFirst()
                                .orElse(WinStatisticsInfo.of(WinPolicy.NONE_MATCH));
  }

  public void clear() {
    this.statisticsInfos.clear();
  }
}
