package lottoauto;

import lottoauto.view.InputViewer;
import lottoauto.view.OutputViewer;
import lottoauto.wrapper.Price;

public class LottoAuto {
    private static InputViewer inputViewer = new InputViewer();

    public LottoAuto() {
        Price price = inputViewer.getInputPrice();
        inputViewer.inputLotto();
        new OutputViewer(inputViewer.getWinNumbers(), price);
    }
}
