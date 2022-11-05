package lotto.service;

import lotto.domain.BuyingLottoGroup;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.strategy.LottoNumberStrategy;

public class LottoService {

    private LottoNumberStrategy buyingLottoNumberStrategy;
    private LottoNumberStrategy winningLottoNumberStrategy;


    public LottoService(LottoNumberStrategy buyingLottoNumberStrategy, LottoNumberStrategy winningLottoNumberStrategy) {
        this.buyingLottoNumberStrategy = buyingLottoNumberStrategy;
        this.winningLottoNumberStrategy = winningLottoNumberStrategy;
    }

    public Lotto generateWinningBasicLotto() {
        return Lotto.create(winningLottoNumberStrategy.generateNumbers());
    }


    public LottoPayment buyLotto(String payLotto) {
        return LottoPayment.create(payLotto);
    }

    public BuyingLottoGroup generateBuyingLottoGroup(int buyLottoCount) {
        return BuyingLottoGroup.create(buyLottoCount, this.buyingLottoNumberStrategy);
    }

    public LottoNumber generateWinningBonusNumber(String inputBonusNumber) {
        return LottoNumber.create(Integer.parseInt(inputBonusNumber));
    }

    public LottoResult getMatchingResultBuyingLottoGroupAndWinningLotto(BuyingLottoGroup buyingLottoGroup,
                                                                        WinningLotto winningLotto) {
        return buyingLottoGroup.matchWinningLotto(winningLotto);
    }
}
