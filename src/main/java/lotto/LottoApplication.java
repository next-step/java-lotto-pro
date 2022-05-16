package lotto;

import lotto.service.LottoNumbersFactory;
import lotto.service.LottoTicketsFactory;
import lotto.view.LottoPresenter;

public class LottoApplication {
    public static void main(String[] args) {
        new LottoPresenter(new LottoNumbersFactory(), new LottoTicketsFactory()).present();
    }
}
