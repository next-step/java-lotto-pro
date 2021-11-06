package step3.dto;

import step3.domain.Amount;
import step3.domain.LottoNumbers;

public class LottoWinNumbersRequestDto {
    private final LottoNumbers lottoNumbers;
    private final Amount amount;

    public LottoWinNumbersRequestDto(int[] readLineToArray, int amount) {
        this.lottoNumbers = new LottoNumbers(readLineToArray);
        this.amount = new Amount(amount);
    }

    public Amount getAmount() {
        return amount;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
