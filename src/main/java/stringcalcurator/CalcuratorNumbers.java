package stringcalcurator;

import java.util.ArrayList;
import java.util.List;

public class CalcuratorNumbers {
  private final List<CalcuratorNumber> items;
     
  public CalcuratorNumbers(List<CalcuratorNumber> items) {
    this.items = new ArrayList<>(items);
  }

  public Integer sum() {
    return items.stream().map(item -> item.value())
                        .reduce((result, seed) -> result += seed)
                        .orElse(0);
  }

}
