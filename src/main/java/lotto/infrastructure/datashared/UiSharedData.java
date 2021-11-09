package lotto.infrastructure.datashared;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;

public class UiSharedData {
  private static Lottos buyLottos;
  private static Lotto latestWinLotto;
  private static LottoNumber bonusNumber;
  private static Integer lottosPrice;
  
  public static void setLottosPrice(Integer lottosPrice) {
    UiSharedData.lottosPrice = lottosPrice;
  }
  
  public static Integer getLottosPrice() {
    return UiSharedData.lottosPrice;
  }

  public static void setBuyLottos(Lottos buyLottos) {
    UiSharedData.buyLottos = buyLottos;
  }

  public static void setLatestWinLotto(Lotto latestWinLotto) {
    UiSharedData.latestWinLotto = latestWinLotto;
  }

  public static void setBonusNumber(LottoNumber bonusNumber) {
    UiSharedData.bonusNumber = bonusNumber;
  }

  public static Lottos getBuyLottos() {
    if (UiSharedData.buyLottos == null) {
      throw new IllegalStateException("로또들이 설정되지 않았습니다.");
    }

    return UiSharedData.buyLottos;
  }

  public static Lotto getLatestWinLotto() {
    if (UiSharedData.latestWinLotto == null) {
      throw new IllegalStateException("당첨 로또번호가 설정되지 않았습니다.");
    }

    return UiSharedData.latestWinLotto;
  }

  public static LottoNumber getBonusNumber() {
    if (UiSharedData.latestWinLotto == null) {
      throw new IllegalStateException("보너스 번호가 설정되지 않았습니다.");
    }

    return UiSharedData.bonusNumber;
  }
}
