package lotto;

import lotto.controller.ConsoleLottoInput;
import lotto.controller.LottoController;
import lotto.controller.LottoUserInput;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.view.ConsoleLottoView;
import lotto.view.LottoView;

public class LottoApplication {
    public static final int lottoFee = 1000;

    public static void main(String[] args) {
        LottoView view = new ConsoleLottoView();
        LottoUserInput input = new ConsoleLottoInput();
        LottoMachine lottoMachine = new LottoMachine();
        LottoStore lottoStore = new LottoStore(lottoMachine, Money.of(lottoFee));


        LottoController lottoController = new LottoController(view,input,lottoStore);
        lottoController.start();
    }
}
