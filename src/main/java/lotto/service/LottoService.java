package lotto.service;

import lotto.domain.*;
import lotto.ui.InputMessage;
import lotto.ui.InputView;
import lotto.ui.ResultView;
/***
 *  피드백 1) 출력에 대한 책임을 도메인에게 주는 것보다 도메인의 값을 활용하자.
 *     참고 : https://javacan.tistory.com/entry/methods-about-exporting-domain-object-to-view
 *
 */

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
        ResultView.printPurchaseResult(price);

        Lottos lottos = this.getLottos(price);
        ResultView.printPurchasedLotto(lottos);

        Lotto winning = this.inputWinningNumber();
        WinningLotto lottoWithBonus = this.inputBonusNumber(winning);

        Ranks results = this.lottoResults(lottos, lottoWithBonus);
        ResultView.printLottoResult(results);
    }


     private PurchasePrice purchase() {
        try {
            ResultView.print(InputMessage.PURCHASE.getMessage());
            return PurchasePrice.valueOf(InputView.readLine());
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return purchase();
        }
    }

    private WinningLotto inputBonusNumber(Lotto winning) {
        try {
            ResultView.print(InputMessage.BONUS.getMessage());
            String input = InputView.readLine();
            LottoNumber bonus = LottoNumber.valueOf(input);
            return new WinningLotto(winning, bonus);
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputBonusNumber(winning);
        }
    }


    private Lottos getLottos(PurchasePrice price) {
        return price.buyLottery();
    }

    private Lotto inputWinningNumber() {
        try {
            ResultView.print(InputMessage.NUMBER.getMessage());
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

