package step3.service;

import step3.domain.LottoBuyCount;
import step3.domain.LottoBuyer;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoRanks;
import step3.domain.LottoService;
import step3.domain.WinningLotto;
import step3.dto.LottoStatisticsResponseDto;

public class LottoServiceImpl implements LottoService {

    @Override
    public LottoBuyCount buyLotto(LottoBuyer lottoBuyer, LottoNumbersBundle lottoNumbersBundle) {
        return lottoBuyer.buyLotto(lottoNumbersBundle);
    }

    @Override
    public LottoStatisticsResponseDto resultStatistics(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        LottoRanks lottoRanks = lottoBuyer.getLottoRanks(winningLotto);
        return new LottoStatisticsResponseDto(lottoRanks);
    }

}
