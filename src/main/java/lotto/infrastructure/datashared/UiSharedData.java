package lotto.infrastructure.datashared;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class UiSharedData {
  private static Lottos buyLottos = new Lottos();
  private static Lotto latestWinLotto = new Lotto();

  public UiSharedData() {
  }

  public static void setBuyLottos(Lottos buyLottos) {
    UiSharedData.buyLottos = buyLottos;
  }

  public static void setLatestWinLotto(Lotto latestWinLotto) {
    UiSharedData.latestWinLotto = latestWinLotto;
  }

  public static Lottos getBuyLottos() {
    if (UiSharedData.buyLottos == null) {
      return new Lottos();
    }

    return UiSharedData.buyLottos;
  }

  public static Lotto getLatestWinLotto() {
    if (UiSharedData.latestWinLotto == null) {
      return new Lotto();
    }

    return UiSharedData.latestWinLotto;
  }
}
