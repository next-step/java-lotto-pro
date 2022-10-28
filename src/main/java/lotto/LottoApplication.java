package lotto;

import lotto.controller.ConsoleLottoInput;
import lotto.controller.LottoController;
import lotto.controller.LottoUserInput;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.view.SimpleLottoView;
import lotto.view.ConsoleOutputTarget;
import lotto.view.LottoView;
import lotto.view.OutputTarget;

public class LottoApplication {
    public static final int lottoFee = 1000;

    public static void main(String[] args) {
        OutputTarget output = new ConsoleOutputTarget();
        LottoView view = new SimpleLottoView(output);
        LottoUserInput input = new ConsoleLottoInput();
        LottoMachine lottoMachine = new LottoMachine();
        LottoStore lottoStore = new LottoStore(lottoMachine, Money.of(lottoFee));


        LottoController lottoController = new LottoController(view,input,lottoStore);
        lottoController.start();
    }
}
