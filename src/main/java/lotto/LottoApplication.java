package lotto;

import lotto.domain.LottoTicketsFactory;
import lotto.view.LottoPresenter;

public class LottoApplication {
    public static void main(String[] args) {
        new LottoPresenter(new LottoTicketsFactory()).present();
    }
}
