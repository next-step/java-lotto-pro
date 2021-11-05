package lotto.domain.winstatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.winpolicy.Policy;
import lotto.domain.winpolicy.WinPolicy;

public class WinStatisticsInfos {
  private final List<WinStatisticsInfo> values;

  private WinStatisticsInfos(List<WinStatisticsInfo> values) {
    this.values = values;
  }

  public WinStatisticsInfos() {
    this.values = new ArrayList<WinStatisticsInfo>();
  }

  public static WinStatisticsInfos of(Policy ... values) {
    return Stream.of(WinPolicy.values())
                  .map(WinStatisticsInfo::of)
                  .collect(Collectors.collectingAndThen(Collectors.toList(), WinStatisticsInfos::new));
  }

  public Integer size() {
    return values.size();
  }

  public WinStatisticsInfo get(Integer index) {
    return values.get(index);
  }

  public boolean add(WinStatisticsInfo value) {
    return values.add(value);
  }

  public Policy getWinPolicy(Integer index) {
    return values.get(index).getPolicy();
  }

  public WinStatisticsInfo findBy(WinPolicy winPolicy) {
    return values.stream()
                  .filter(item -> item.getWinPolicy().equals(winPolicy))
                  .findFirst()
                  .orElse(WinStatisticsInfo.of(WinPolicy.NONE_MATCH));
  }

  public void clear() {
    values.clear();
  }
}
