package lotto.service;

import lotto.common.exceptions.CustomEmptyException;
import lotto.common.utils.StringUtil;
import lotto.domain.*;
import lotto.ui.InputMessage;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private int inputManualLottoCount(PurchasePrice price) {
        try {
            ResultView.print(InputMessage.MANUAL_COUNT.getMessage());
            Optional<String> input = Optional.ofNullable(InputView.readLine());
            if (!input.isPresent()) throw new CustomEmptyException();
            int count = StringUtil.parseNumber(input.get());
            if (!price.isAbleToBuy(count)) throw new IllegalArgumentException("구매 가능한 수량을 초과하였습니다.");
            return count;
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputManualLottoCount(price);
        }
    }

    private Lotto inputManualLottoNumber() {
        try {
            return new Lotto(InputView.readLine());
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputManualLottoNumber();
        }
    }


    private WinningLotto inputBonusNumber(Lotto winning) {
        try {
            ResultView.print(InputMessage.BONUS.getMessage());
            String input = InputView.readLine();
            LottoNumber bonus = LottoNumber.valueOf(input);
            return WinningLotto.valueOf(winning, bonus);
        } catch (Exception e) {
            ResultView.print(e.getMessage());
            return inputBonusNumber(winning);
        }
    }


    private Lottos getLottos(PurchasePrice price) {
        int manualCount = this.inputManualLottoCount(price);
        List<Lotto> lottoList = this.createManualLottoList(manualCount);
        lottoList.addAll(price.buyAutomaticLottoExceptManualCnt(manualCount));
        ResultView.printPurchaseResult(manualCount, price.calculateQuantity() - manualCount);
        return new Lottos(lottoList);
    }

    private List<Lotto> createManualLottoList(int manualCount) {
        List<Lotto> lottoList = new ArrayList<>();
        ResultView.print(InputMessage.MANUAL_NUMBER.getMessage());
        for (int i = 0; i < manualCount; i++) {
            lottoList.add(this.inputManualLottoNumber());
        }
        return lottoList;
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

