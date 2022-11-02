package lotto.dto;

public class LottoResultRequestDto {

    private LotteriesDto lotteriesDto;
    private WinningNumbersDto winningNumbers;
    private String buyAmountUserInput;

    public LottoResultRequestDto(LotteriesDto lotteriesDto, WinningNumbersDto winningNumbers, String buyAmountUserInput) {
        this.lotteriesDto = lotteriesDto;
        this.winningNumbers = winningNumbers;
        this.buyAmountUserInput = buyAmountUserInput;
    }

    public LotteriesDto getLotteriesDto() {
        return lotteriesDto;
    }

    public WinningNumbersDto getWinningNumbers() {
        return winningNumbers;
    }


    public String getBuyAmountUserInput() {
        return buyAmountUserInput;
    }
}
