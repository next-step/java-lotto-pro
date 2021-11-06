package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {
  private final List<Lotto> lottos;

  private Lottos(List<Lotto> lottos) {
    this.lottos = new ArrayList<>(lottos);
  }

  public static Lottos valueOf(List<Lotto> lottos) {
    return new Lottos(lottos);
  }
  
  public static Lottos valueOf(Lotto ... lottos) {
    return new Lottos(Arrays.asList(lottos));
  }

  public Integer size() {
    return this.lottos.size();
  }

  public Lotto get(Integer index) {
    return this.lottos.get(index);
  }

  public Integer getPrice() {
    return Lotto.PRICE * this.lottos.size();
  }
  
  public Stream<Lotto> getStream() {
    return this.lottos.stream();
  }
}
