package lotto.controller;

import lotto.controller.validator.LottoValidator;
import lotto.domain.LottoNumbers;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();
    private final LottoValidator lottoValidator = new LottoValidator();

    public int countPurchasableLotto(int amount) {
        lottoValidator.validateCountPurchasableLotto(amount);
        return lottoService.countPurchasableLotto(amount);
    }

    public LottoNumbers createLottoNumbers() {
        return lottoService.createLottoNumbers();
    }

    public int countWinningNumber(LottoNumbers winningLottoNumbers, LottoNumbers myLottoNumbers) {
        lottoValidator.validateCountWinningNumber(winningLottoNumbers, myLottoNumbers);
        return lottoService.countWinningNumber(winningLottoNumbers, myLottoNumbers);
    }

    public double getRateOfReturn(int purchaseCount, int winningAmount) {
        lottoValidator.validateGetRateOfReturn(purchaseCount, winningAmount);
        return lottoService.getRateOfReturn(purchaseCount, winningAmount);
    }
}
