package lotto.service;

import static lotto.view.InputView.buyManualLotto;
import static lotto.view.InputView.inputBonusNumber;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.BuyingLottoGroup;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.domain.ManualLottoCount;
import lotto.domain.WinningLotto;
import lotto.strategy.ConsoleLottoGenerateStrategy;
import lotto.strategy.LottoGenerateStrategy;

public class LottoService {

    private Logger log = LoggerFactory.getLogger(LottoService.class);
    private LottoGenerateStrategy buyingLottoGenerateStrategy;
    private LottoGenerateStrategy winningLottoGenerateStrategy;


    public LottoService(LottoGenerateStrategy buyingLottoGenerateStrategy, LottoGenerateStrategy winningLottoGenerateStrategy) {
        this.buyingLottoGenerateStrategy = buyingLottoGenerateStrategy;
        this.winningLottoGenerateStrategy = winningLottoGenerateStrategy;
    }

    public Lotto generateWinningBasicLotto() {
        return winningLottoGenerateStrategy.generateLotto();
    }

    public ManualLottoCount generateManualLottoCount(LottoPayment lottoPayment){
        try{
            return ManualLottoCount.create(buyManualLotto(), lottoPayment.getLottoCount());
        }catch(IllegalArgumentException e){
            log.error("[ERROR] " + e.getLocalizedMessage());
            return generateManualLottoCount(lottoPayment);
        }
    }

    public LottoPayment buyLotto(String payLotto) {
        return LottoPayment.create(payLotto);
    }

    public List<Lotto> generateManualLotto(int manualLottoCount){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i < manualLottoCount; i++){
            lottoList.add(new ConsoleLottoGenerateStrategy().generateLotto());
        }
        return lottoList;
    }

    public BuyingLottoGroup generateBuyingLottoGroup(int buyLottoCount, int manualLottoCount) {
        return BuyingLottoGroup.create(buyLottoCount-manualLottoCount, this.buyingLottoGenerateStrategy, generateManualLotto(manualLottoCount));
    }

    public LottoNumber generateWinningBonusNumber() {
        try{
            return LottoNumber.create(Integer.parseInt(inputBonusNumber()));
        }catch(IllegalArgumentException e){
            log.error("[ERROR] " + e.getLocalizedMessage());
            return generateWinningBonusNumber();
        }
    }

    public LottoResult getMatchingResultBuyingLottoGroupAndWinningLotto(BuyingLottoGroup buyingLottoGroup,
                                                                        WinningLotto winningLotto) {
        return buyingLottoGroup.matchWinningLotto(winningLotto);
    }
}
