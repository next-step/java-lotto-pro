package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.presentation.AutoGenerateLottoNumber;
import lotto.presentation.BuyLotto;
import lotto.presentation.ReportWinStatistics;
import lotto.presentation.Screen;
import lotto.presentation.SettingLatestWinLotto;

public class LottoApplication {
  public static void main(String[] args) {
    for (Screen screen : settingScreen()) {
      screen.render();
    }
  }

  private static List<Screen> settingScreen() {
    List<Screen> screens = new ArrayList<>();

    BuyLotto buyLotto = new BuyLotto();
    AutoGenerateLottoNumber autoGenerateLottoNumber = new AutoGenerateLottoNumber();
    SettingLatestWinLotto settingLatestWinLotto = new SettingLatestWinLotto();
    ReportWinStatistics reportWinStatistics = new ReportWinStatistics();

    screens.add(buyLotto);
    screens.add(autoGenerateLottoNumber);
    screens.add(settingLatestWinLotto);
    screens.add(reportWinStatistics);

    return screens;
  }
}
