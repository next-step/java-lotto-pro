package step3.domain;

import java.util.List;

import step3.domain.strategy.numbers.NumbersStrategy;
import step3.dto.LottoBoughtListResponse;
import step3.dto.LottoStatisticsResponseDto;

public interface LottoService {
    void registerBuyAmount(int buyAmount);

    void registerManualLottoBuy(List<NumbersStrategy> manualLottoNumbers);

    void buyAutoLotto();

    LottoBoughtListResponse getBoughtLottos();

    void winningLottoNumber(NumbersStrategy winningLottoNumber, int bonusNumber);

    LottoStatisticsResponseDto resultStatistics();
}
