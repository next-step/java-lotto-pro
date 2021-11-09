package step3.service;

import java.util.ArrayList;
import java.util.List;

import step3.domain.Amount;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoProvider;
import step3.domain.LottoRanks;
import step3.domain.LottoService;
import step3.domain.WinningLotto;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomLottoNumbers;
import step3.dto.LottoBoughtListResponse;
import step3.dto.LottoResultDto;
import step3.dto.LottoStatisticsResponseDto;

public class LottoServiceImpl implements LottoService {
    LottoProvider lottoProvider = new LottoProvider();
    Amount amount;
    LottoNumbersBundle manualLottoNumbersBundle;
    LottoNumbersBundle autoLottoNumbersBundle;
    WinningLotto winningLotto;

    @Override
    public void registerBuyAmount(int buyAmount) {
        this.amount = new Amount(buyAmount);
    }

    @Override
    public void registerManualLottoBuy(List<NumbersStrategy> manualLottoNumbers) {
        manualLottoNumbersBundle = lottoProvider.buyLotto(manualLottoNumbers);
        amount.minusAmount(manualLottoNumbers.size());
    }

    @Override
    public void buyAutoLotto() {
        List<NumbersStrategy> autoLottoNumbers = new ArrayList<>();
        for (int i = 0; i < amount.buyAvailableQuantity(); i++) {
            autoLottoNumbers.add(new RandomLottoNumbers());
        }

        autoLottoNumbersBundle = lottoProvider.buyLotto(autoLottoNumbers);
        amount.minusAmount(autoLottoNumbers.size());
    }

    @Override
    public LottoBoughtListResponse getBoughtLottos() {

        return new LottoBoughtListResponse(manualLottoNumbersBundle, autoLottoNumbersBundle);
    }

    @Override
    public void winningLottoNumber(NumbersStrategy winningLottoNumber, int bonusNumber) {
        this.winningLotto = WinningLotto.of(winningLottoNumber.getNumbers(), bonusNumber);
    }

    @Override
    public LottoStatisticsResponseDto resultStatistics() {
        List<LottoResultDto> result = new ArrayList<>();

        LottoRanks lottoRanks = lottoProvider.getLottoResult(manualLottoNumbersBundle, autoLottoNumbersBundle,
            winningLotto);

        return new LottoStatisticsResponseDto(lottoRanks, amount);
    }
}
