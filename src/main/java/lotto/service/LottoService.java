package lotto.service;

import lotto.domain.*;
import lotto.ui.InputType;
import lotto.ui.InputView;
import lotto.ui.Message;
import lotto.ui.ResultView;

/**
 * packageName : lotto.service
 * fileName : LottoServiceImpl
 * author : haedoang
 * date : 2021/11/05
 * description : 로또 게임 서비스
 */
public class LottoService {
    public void start() {
        PurchasePrice price = this.purchase();
        price.print();
        Lottos lottos = this.getLottos(price);
        lottos.print();
        Lotto winning = this.inputWinningNumber();
        WinningLotto lottoWithBonus = this.inputBonusNumber(winning);
        Ranks results = this.lottoResults(lottos, lottoWithBonus);
        results.print();
    }


    public PurchasePrice purchase() {
        try {
            ResultView.print(Message.PURCHASE.getMessage());
            return new PurchasePrice(InputView.readLine());
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return purchase();
        }
    }

    private WinningLotto inputBonusNumber(Lotto winning) {
        try {
            ResultView.print(Message.BONUS.getMessage());
            String input = InputView.readLine();
            LottoNumber bonus = new LottoNumber(input);
            return new WinningLotto(winning, bonus);
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputBonusNumber(winning);
        }
    }


    public Lottos getLottos(PurchasePrice price) {
        return price.buyLottery();
    }

    public Lotto inputWinningNumber() {
        try {
            ResultView.print(Message.NUMBER.getMessage());
            return new Lotto(InputView.readLine());
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputWinningNumber();
        }
    }

    private Ranks lottoResults(Lottos lottos, WinningLotto lottoWithBonus) {
        return lottos.getResults(lottoWithBonus);
    }


}

