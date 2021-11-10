package step3.service;

import step3.domain.Amount;
import step3.domain.LottoBuyer;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoRanks;
import step3.domain.LottoService;
import step3.domain.WinningLotto;
import step3.dto.LottoStatisticsResponseDto;

public class LottoServiceImpl implements LottoService {

    @Override
    public LottoBuyer registerLottoBuyer(int buyAmount) {
        return new LottoBuyer(new Amount(buyAmount));
    }

    @Override
    public void buyLotto(LottoBuyer lottoBuyer, LottoNumbersBundle lottoNumbersBundle) {
        lottoBuyer.buyLotto(lottoNumbersBundle);
        lottoBuyer.autoBuyLotto();
    }

    @Override
    public LottoStatisticsResponseDto resultStatistics(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        LottoRanks lottoRanks = lottoBuyer.getLottoRanks(winningLotto);
        return new LottoStatisticsResponseDto(lottoRanks);
    }

}
