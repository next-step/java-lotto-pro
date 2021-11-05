package step3.dto;

import step3.domain.LottoNumbers;
import step3.domain.strategy.numbers.NumbersStrategy;

public class WinnerLottoNumbersDto extends LottoNumbers {

    public WinnerLottoNumbersDto(int[] numbers) {
        super(numbers);
    }
}
