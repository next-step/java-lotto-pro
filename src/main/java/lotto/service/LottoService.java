package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.Ranks;
import lotto.ui.InputType;
import lotto.ui.InputView;
import lotto.ui.ResultView;

/**
 * packageName : lotto.service
 * fileName : LottoServiceImpl
 * author : haedoang
 * date : 2021/11/05
 * description :
 */
public class LottoService {
    public void start() {
        PurchasePrice price = this.purchase();
        price.print();
        Lottos lottos = this.getLottos(price);
        lottos.print();
        Lotto winning = this.inputWinningNumber();
        Ranks results = lottos.getResults(winning);
        results.print();
    }

    public PurchasePrice purchase() {
        try {
            ResultView.print(InputType.PURCHASE);
            return new PurchasePrice(InputView.readLine());
        } catch(Exception e) {
            ResultView.print(e.getMessage());
            return purchase();
        }
    }

    public Lottos getLottos(PurchasePrice price){
        return price.buyLottery();
    }

    public Lotto inputWinningNumber() {
        try {
            ResultView.print(InputType.NUMBER);
            return new Lotto(InputView.readLine());
        } catch(Exception e) {
            ResultView.print(e.getMessage());
            return inputWinningNumber();
        }
    }


}

