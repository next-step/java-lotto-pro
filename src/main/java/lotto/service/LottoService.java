package lotto.service;

import lotto.domain.LottoGame;
import lotto.domain.LottoLine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;

public class LottoService {

    public LottoGame buyLotto(LottoPayment lottoPayment){
        return LottoGame.issueLotto(getLottoLineCount(lottoPayment));
    }

    private int getLottoLineCount(LottoPayment lottoPayment){
        return lottoPayment.getLottoLineCount();
    }

    public LottoResult getLottoResult(LottoGame lottoGame, LottoLine winLottoLine, LottoNumber bonusNumber){
        return lottoGame.getLottoResult(winLottoLine, bonusNumber);
    }
}
