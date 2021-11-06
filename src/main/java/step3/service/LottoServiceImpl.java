package step3.service;

import step3.domain.Amount;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoProvider;
import step3.domain.LottoResult;
import step3.domain.LottoService;
import step3.domain.strategy.numbers.RandomLottoNumbers;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoStatisticsResponseDto;
import step3.dto.LottoWinNumbersRequestDto;

public class LottoServiceImpl implements LottoService {
    LottoProvider lottoProvider = new LottoProvider();

    @Override
    public LottoBuyResponseDto buyLotto(LottoBuyRequestDto lottoBuyRequestDto) {
        int quantity = lottoProvider.availableQuantity(lottoBuyRequestDto.getAmount());
        LottoNumbersBundle lottoNumbersBundle = lottoProvider.buyLotto(quantity, new RandomLottoNumbers());

        return new LottoBuyResponseDto(lottoNumbersBundle.getLottoNumbersBundle());
    }

    @Override
    public LottoStatisticsResponseDto getResultStatistics(LottoWinNumbersRequestDto lottoWinNumbersRequestDto) {
        LottoResult lottoResult = lottoProvider.getLottoResult(
            lottoWinNumbersRequestDto.getLottoNumbers(),
            lottoWinNumbersRequestDto.getAmount()
        );
        
        return new LottoStatisticsResponseDto(lottoResult);
    }
}
