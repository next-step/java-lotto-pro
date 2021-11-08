package step3.service;

import step3.domain.LottoNumbersBundle;
import step3.domain.LottoProvider;
import step3.domain.LottoRanks;
import step3.domain.LottoResult;
import step3.domain.LottoService;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoManualLottoNumbersRequestDto;
import step3.dto.LottoStatisticsRequestDto;
import step3.dto.LottoStatisticsResponseDto;

public class LottoServiceImpl implements LottoService {
    LottoProvider lottoProvider = new LottoProvider();

    @Override
    public LottoBuyResponseDto buyLotto(LottoBuyRequestDto lottoBuyRequestDto, NumbersStrategy numbersStrategy) {
        int quantity = lottoProvider.availableQuantity(lottoBuyRequestDto.getAmount());

        LottoNumbersBundle lottoNumbersBundle = lottoProvider.buyLotto(quantity, numbersStrategy);

        return new LottoBuyResponseDto(lottoNumbersBundle);
    }

    @Override
    public LottoBuyResponseDto buyLotto(LottoManualLottoNumbersRequestDto lottoManualLottoNumbersRequestDto) {
        LottoNumbersBundle lottoNumbersBundle = lottoProvider.buyLotto(
            lottoManualLottoNumbersRequestDto.getManualLottoNumbers());
        return new LottoBuyResponseDto(lottoNumbersBundle);
    }

    @Override
    public LottoStatisticsResponseDto getResultStatistics(LottoStatisticsRequestDto lottoStatisticsRequestDto) {
        LottoRanks lottoRanks = lottoProvider.getLottoResult(
            new LottoNumbersBundle(lottoStatisticsRequestDto.getBuyLottoList()),
            lottoStatisticsRequestDto.getWinningLotto()
        );

        return new LottoStatisticsResponseDto(lottoRanks);
    }

}
