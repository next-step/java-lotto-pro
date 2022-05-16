package lottoauto;

import lottoauto.service.LottoTicket;
import lottoauto.view.InputViewer;
import lottoauto.view.OutputViewer;
import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Price;

public class LottoAuto {

    private static LottoTicket lottoTicket = new LottoTicket();
    private static Lotto winNumbers;
    private static InputViewer inputViewer = new InputViewer();

    public LottoAuto() {

        Price price = inputViewer.getInputPrice();
        inputViewer.inputLottoPrint();
        OutputViewer outputView = new OutputViewer(inputViewer.getWinNumbers(), price);

    }
}
