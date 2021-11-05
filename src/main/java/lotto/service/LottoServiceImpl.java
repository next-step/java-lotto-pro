package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.Ranks;
import lotto.ui.InputType;
import lotto.ui.InputView;

/**
 * packageName : lotto.service
 * fileName : LottoServiceImpl
 * author : haedoang
 * date : 2021/11/05
 * description :
 */
public class LottoServiceImpl implements LottoService {
    @Override
    public void start() {
        PurchasePrice price = (PurchasePrice) InputView.readLine(InputType.PURCHASE);
        price.print();
        Lottos lottos = price.buyLottery();
        lottos.print();
        Lotto winning = (Lotto) InputView.readLine(InputType.NUMBER);
        Ranks results = lottos.getResults(winning);
        results.print();
    }


}

