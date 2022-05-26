package lottoauto;

import lottoauto.service.LottoTicket;
import lottoauto.view.InputViewer;
import lottoauto.view.OutputViewer;
import lottoauto.wrapper.Price;
import lottoauto.wrapper.TryTime;

public class LottoAuto {
    private static InputViewer inputViewer = new InputViewer();
    public LottoAuto() {
        Price price = inputViewer.getInputPrice();
        TryTime tryTime = new TryTime(price.getPrice());
        inputViewer.inputLotto(tryTime);
        new OutputViewer(inputViewer.getWinNumbers(), price);
    }
}
