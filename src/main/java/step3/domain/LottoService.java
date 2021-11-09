package step3.domain;

import java.util.List;

import step3.domain.strategy.numbers.NumbersStrategy;
import step3.dto.LottoBoughtListResponse;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoManualLottoNumbersRequestDto;
import step3.dto.LottoResultDto;
import step3.dto.LottoStatisticsRequestDto;
import step3.dto.LottoStatisticsResponseDto;

public interface LottoService {
    void registerBuyAmount(int buyAmount);

    void registerManualLottoBuy(List<NumbersStrategy> manualLottoNumbers);

    void buyAutoLotto();

    LottoBoughtListResponse getBoughtLottos();

    void winningLottoNumber(NumbersStrategy winningLottoNumber, int bonusNumber);

    LottoStatisticsResponseDto resultStatistics();

    //
    @Deprecated
    LottoBuyResponseDto buyLotto(LottoBuyRequestDto lottoBuyRequestDto, NumbersStrategy numbersStrategy);

    @Deprecated
    LottoStatisticsResponseDto getResultStatistics(LottoStatisticsRequestDto lottoStatisticsRequestDto);

    @Deprecated
    LottoBuyResponseDto buyLotto(LottoManualLottoNumbersRequestDto lottoManualLottoNumbersRequestDto);

}
