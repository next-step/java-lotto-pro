package step3.service;

import step3.domain.Amount;
import step3.domain.LottoProvider;
import step3.domain.LottoService;
import step3.domain.strategy.lotto.LottoProviderStrategy;
import step3.dto.LottoRanksDto;
import step3.dto.WinnerLottoNumbersDto;

public class LottoServiceImpl implements LottoService {
    LottoProviderStrategy lottoProvider = new LottoProvider();

    @Override
    public void buyLotto(Amount amount) {
        int quantity = lottoProvider.availableQuantity(amount.getAmount());
        lottoProvider.buyLotto(quantity);
    }

    @Override
    public LottoRanksDto lottoPurchaseDetails(Amount amount, WinnerLottoNumbersDto winLottoNumbers) {
        return LottoRanksDto.of(
            lottoProvider.getLottoNumbersBundle().lottoRanksOf(winLottoNumbers), amount);
    }

}
