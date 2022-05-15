package step3.model;

import java.util.HashMap;
import java.util.List;
import step3.domain.LottoManager;
import step3.domain.LottoTicket;

public class LottoMachine {

    private final LottoManager lottoManager;

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

    public String buyTicket(String money) {
        try {
            lottoManager.buyRandomTicket(money);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return money;
    }

    public List<List<String>> getLottoNumbers() {
        return lottoManager.getLottoNumbers();
    }

}
