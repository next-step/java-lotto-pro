package lotto.dto;

public class LottoResultRequestDto {

    private LotteriesDto lotteriesDto;
    private WinningNumbersDto winningNumbers;
    private BuyAmountDto buyAmountDto;

    public LottoResultRequestDto(LotteriesDto lotteriesDto, WinningNumbersDto winningNumbers, BuyAmountDto buyAmountDto) {
        this.lotteriesDto = lotteriesDto;
        this.winningNumbers = winningNumbers;
        this.buyAmountDto = buyAmountDto;
    }

    public LotteriesDto getLotteriesDto() {
        return lotteriesDto;
    }

    public WinningNumbersDto getWinningNumbers() {
        return winningNumbers;
    }

    public BuyAmountDto getBuyAmountDto() {
        return buyAmountDto;
    }
}
