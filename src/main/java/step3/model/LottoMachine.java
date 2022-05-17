package step3.model;

import java.util.HashMap;
import java.util.List;
import step3.domain.LottoElement;
import step3.domain.LottoManager;
import step3.domain.LottoTicket;
import step3.domain.Money;

public class LottoMachine {

    private final LottoManager lottoManager;
    private final int LOTTO_PRICE = 1_000;
    private final String CANT_BUY_LOTTO_EXCEPTION = "돈은 최소 " + LOTTO_PRICE + "이상 입력해야합니다";


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
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int buyTicket(Money money) {
        if(!validateTicketCount(money)){
            System.out.println(CANT_BUY_LOTTO_EXCEPTION);
            return 0;
        }
        int ticket = money.getMoney() / LOTTO_PRICE;
        return lottoManager.buyRandomTicket(ticket);
    }
    private boolean validateTicketCount(Money money){
        try {
            return money.getMoney() / LOTTO_PRICE >= 1;
        }catch (NullPointerException e){
            return false;
        }
    }
    public Money insertMoney(String money) {
        try {
            return new Money(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<List<LottoElement>> getLottoNumbers() {
        return lottoManager.getLottoNumbers();
    }

}
