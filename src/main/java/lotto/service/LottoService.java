package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BuyingLottoGroup;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.strategy.ConsoleLottoNumberStrategy;
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

    public List<Lotto> generateManualLotto(int manualLottoCount){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i < manualLottoCount; i++){
            lottoList.add(Lotto.create(new ConsoleLottoNumberStrategy().generateNumbers()));
        }
        return lottoList;
    }

    public BuyingLottoGroup generateBuyingLottoGroup(int buyLottoCount, int manualLottoCount) {
        return BuyingLottoGroup.create(buyLottoCount-manualLottoCount, this.buyingLottoNumberStrategy, generateManualLotto(manualLottoCount));
    }

    public LottoNumber generateWinningBonusNumber(String inputBonusNumber) {
        return LottoNumber.create(Integer.parseInt(inputBonusNumber));
    }

    public LottoResult getMatchingResultBuyingLottoGroupAndWinningLotto(BuyingLottoGroup buyingLottoGroup,
                                                                        WinningLotto winningLotto) {
        return buyingLottoGroup.matchWinningLotto(winningLotto);
    }
}
