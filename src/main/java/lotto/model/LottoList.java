package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

  private final List<Lotto> lottoList;

  public LottoList(int amount) {
    this.lottoList = generateLotto(amount);
  }

  public List<Lotto> getLottoList() {
    return this.lottoList;
  }

  private List<Lotto> generateLotto(int amount) {
    List<Lotto> lottoList = new ArrayList<Lotto>();

    for (int i = 0; i < amount; i++) {
      lottoList.add(new Lotto());
    }

    return lottoList;
  }

}
