package step3.domain;

import step3.dto.LottoStatisticsResponseDto;

public interface LottoService {

    LottoBuyCount buyLotto(LottoBuyer lottoBuyer, LottoNumbersBundle lottoNumbersBundle2);

    LottoStatisticsResponseDto resultStatistics(LottoBuyer lottoBuyer, WinningLotto winningLotto);

}
