package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {
  private final List<Lotto> values;

  public Lottos() {
    this.values = new ArrayList<>();
  }

  public Lottos(List<Lotto> values) {
    this.values = new ArrayList<>(values);
  }

  public static Lottos valueOf(Lotto ... value) {
    return new Lottos(Arrays.asList(value));
  }

  public Integer size() {
    return values.size();
  }

  public Lotto get(Integer index) {
    return values.get(index);
  }

  public Integer getPrice() {
    return Lotto.PRICE * values.size();
  }
}
