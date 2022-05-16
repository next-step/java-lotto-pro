package lotto;

import lotto.domain.LottoNumbersFactory;
import lotto.domain.LottoPaymentFactory;
import lotto.domain.LottoTicketsFactory;
import lotto.view.LottoPresenter;

public class LottoApplication {
    public static void main(String[] args) {
        new LottoPresenter(new LottoPaymentFactory(), new LottoNumbersFactory(), new LottoTicketsFactory()).present();
    }
}
