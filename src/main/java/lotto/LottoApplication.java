package lotto;

import lotto.conotroller.Lotto;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            Lotto lotto = new Lotto();
            lotto.run();
        } catch (Exception e) {
            OutputView.error(e.getMessage());
        }
    }
}
