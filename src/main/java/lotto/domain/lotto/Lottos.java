package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lotto.domain.winpolicy.Policy;

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

  public Lotto get(Integer index) {
    return lottos.get(index);
  }

  public Integer size() {
    return lottos.size();
  }

  public Integer getPrice() {
    return Lotto.PRICE * this.lottos.size();
  }

  public Integer matchCount(Policy policy, Lotto latestWinLotto) {
    return (int) lottos.stream()
                        .filter(lotto -> policy.isMatch(latestWinLotto, lotto))
                        .count();
  }
}
