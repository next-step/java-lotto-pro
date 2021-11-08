package step3.service;

import step3.domain.LottoNumbersBundle;
import step3.domain.LottoProvider;
import step3.domain.LottoResult;
import step3.domain.LottoService;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomLottoNumbers;
import step3.dto.LottoBonusNumberRequestDto;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoStatisticsResponseDto;
import step3.dto.LottoWinNumbersRequestDto;

public class LottoServiceImpl implements LottoService {
    LottoProvider lottoProvider = new LottoProvider();

    @Override
    public LottoBuyResponseDto buyLotto(LottoBuyRequestDto lottoBuyRequestDto, NumbersStrategy numbersStrategy) {
        int quantity = lottoProvider.availableQuantity(lottoBuyRequestDto.getAmount());

        LottoNumbersBundle lottoNumbersBundle = lottoProvider.buyLotto(quantity, numbersStrategy);

        return new LottoBuyResponseDto(lottoNumbersBundle);
    }

    @Override
    public LottoStatisticsResponseDto getResultStatistics(LottoWinNumbersRequestDto lottoWinNumbersRequestDto,
        LottoBonusNumberRequestDto lottoBonusNumberRequestDto) {

        LottoResult lottoResult = lottoProvider.getLottoResult(
            lottoWinNumbersRequestDto.getLottoNumbers(),
            lottoWinNumbersRequestDto.getAmount(),
            lottoBonusNumberRequestDto.getBonusLottoNumber()
        );

        return new LottoStatisticsResponseDto(lottoResult);
    }
}
