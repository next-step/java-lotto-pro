package step3.domain;

import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoStatisticsResponseDto;
import step3.dto.LottoWinNumbersRequestDto;

public interface LottoService {
    LottoBuyResponseDto buyLotto(LottoBuyRequestDto lottoBuyRequestDto);

    LottoStatisticsResponseDto getResultStatistics(LottoWinNumbersRequestDto lottoWinNumbersRequestDto);
}
