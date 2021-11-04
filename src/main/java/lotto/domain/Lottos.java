package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
  private final List<Lotto> values;

  public Lottos(List<Lotto> values) {
    this.values = new ArrayList<>(values);
  }

  public Integer size() {
    return values.size();
  }

  public Lotto get(Integer index) {
    return values.get(index);
  }
}
