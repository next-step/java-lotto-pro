package lotto.presentation;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.infrastructure.component.Label;
import lotto.infrastructure.component.TextEdit;
import lotto.infrastructure.datashared.UiSharedData;

public class BuyLotto extends Screen {
  TextEdit buyingLottoPrice;
  Label resultBuyingLottoCount;

  public BuyLotto() {
    initialize();
  }

  @Override
  public void initialize() {
    buyingLottoPrice = new TextEdit("구입금액을 입력해 주세요.");
    resultBuyingLottoCount = new Label("");
  }

  @Override
  public void render() {
    super.render();

    buyingLottoPrice.render();

    String buyPrice = buyingLottoPrice.getValue();

    int lottoCount = Integer.valueOf(buyPrice) / Lotto.PRICE;

    resultBuyingLottoCount.setPrintText(String.format("%d개를 구매했습니다.", lottoCount));
    resultBuyingLottoCount.render();

    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < lottoCount; i++) {
      LottoNumbers lottoNumbers = new LottoNumbers();
      lottoNumbers.generate();

      lottos.add(new Lotto(lottoNumbers));
    }

    UiSharedData.setBuyLottos(new Lottos(lottos));
  }

  @Override
  public void update() {
  }
}
