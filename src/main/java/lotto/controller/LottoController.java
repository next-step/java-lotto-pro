package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public int countPurchasableLotto(int amount) {
        return lottoService.countPurchasableLotto(amount);
    }

    public LottoNumbers createLottoNumbers() {
        return lottoService.createLottoNumbers();
    }

    public int countWinningNumber(LottoNumbers winningLottoNumbers, LottoNumbers myLottoNumbers) {
        return lottoService.countWinningNumber(winningLottoNumbers, myLottoNumbers);
    }

    public double getRateOfReturn(int purchaseCount, int winningAmount) {
        return lottoService.getRateOfReturn(purchaseCount, winningAmount);
    }
}
