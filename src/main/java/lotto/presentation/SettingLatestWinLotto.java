package lotto.presentation;

import lotto.domain.lotto.Lotto;
import lotto.infrastructure.component.TextEdit;
import lotto.infrastructure.datashared.UiSharedData;

public class SettingLatestWinLotto extends Screen {
  TextEdit latestWinLotto = new TextEdit();

  public SettingLatestWinLotto() {
    initialize();
  }

  @Override
  public void initialize() {
    setTopMargin(1);

    latestWinLotto.setPrintText("지난 주 당첨 번호를 입력해 주세요.");
  }

  @Override
  public void render() {
    super.render();

    latestWinLotto.render();

    String tempLatestWinLotto = latestWinLotto.getValue();
    Lotto latestWinLotto = Lotto.valueOf(tempLatestWinLotto.split(","));


    UiSharedData.setLatestWinLotto(latestWinLotto);
  }

  @Override
  public void update() {
  }

}
