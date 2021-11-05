package lotto.presentation;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lottos;
import lotto.infrastructure.component.Label;
import lotto.infrastructure.datashared.UiSharedData;

public class AutoGenerateLottoNumber extends Screen {
  private final Label lottoLabel;

  public AutoGenerateLottoNumber() {
    lottoLabel = new Label();

    initialize();
  }

  @Override
  public void initialize() {
  }

  @Override
  public void render() {
    super.render();

    lottoLabel.render();
  }

  @Override
  public void update() {
    Lottos lottos = UiSharedData.getBuyLottos();
    List<String> printText = new ArrayList<>();

    for (int i = 0; i < lottos.size(); i++) {
      printText.add("[" + lottos.get(i).toString() + "]");
    }

    lottoLabel.setPrintText(String.join("\n", printText));
  }
}
