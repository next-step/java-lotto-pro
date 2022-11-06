package lotto.service;

import static lotto.view.InputView.buyManualLotto;
import static lotto.view.InputView.inputBonusNumber;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BuyingLottoGroup;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.domain.ManualLottoCount;
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

    public ManualLottoCount generateManualLottoCount(LottoPayment lottoPayment){
        try{
            return ManualLottoCount.create(buyManualLotto(), lottoPayment.getLottoCount());
        }catch(IllegalArgumentException e){
            System.err.println("[ERROR] "+e.getLocalizedMessage());
            return generateManualLottoCount(lottoPayment);
        }
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

    public LottoNumber generateWinningBonusNumber() {
        try{
            return LottoNumber.create(Integer.parseInt(inputBonusNumber()));
        }catch(IllegalArgumentException e){
            System.err.println("[ERROR] " + e.getLocalizedMessage());
            return generateWinningBonusNumber();
        }
    }

    public LottoResult getMatchingResultBuyingLottoGroupAndWinningLotto(BuyingLottoGroup buyingLottoGroup,
                                                                        WinningLotto winningLotto) {
        return buyingLottoGroup.matchWinningLotto(winningLotto);
    }
}
