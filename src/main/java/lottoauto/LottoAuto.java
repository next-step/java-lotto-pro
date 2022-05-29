package lottoauto;

import lottoauto.view.InputViewer;
import lottoauto.view.OutputViewer;
import lottoauto.wrapper.Price;
import lottoauto.wrapper.TryTime;

public class LottoAuto {
    private final static InputViewer inputViewer = new InputViewer();
    private static final int divide = 1000;

    public LottoAuto() {
        Price price = inputViewer.getInputPrice(divide);
        inputViewer.inputLotto(TryTime.of(price.getPrice(), divide));
        new OutputViewer(inputViewer.getWinNumbers(), price);
    }
}
