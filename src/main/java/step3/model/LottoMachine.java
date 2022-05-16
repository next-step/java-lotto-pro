package step3.model;

import java.util.HashMap;
import java.util.List;
import step3.domain.LottoManager;
import step3.domain.LottoTicket;
import step3.domain.Money;

public class LottoMachine {

    private final LottoManager lottoManager;
    private final int BUY_TICKET_ERROR = -1;

    public LottoMachine(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }


    public HashMap<String, Integer> checkWin(LottoTicket winnerLotto) {
        return lottoManager.checkWin(winnerLotto);
    }

    public LottoTicket makeManualLottoTicket(String manualLottoSource) {
        try {
            return lottoManager.makeManualLottoTicket(manualLottoSource);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public int buyTicket(Money money) {
        try {
            return lottoManager.buyRandomTicket(money.purchaseTicket());
        } catch (IllegalArgumentException e) {
            return BUY_TICKET_ERROR;
        }
    }

    public Money createMoney(String money) {
        try {
            return new Money(money);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoManager.getLottoNumbers();
    }

}
