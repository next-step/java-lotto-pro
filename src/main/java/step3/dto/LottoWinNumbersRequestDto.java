package step3.dto;

import step3.common.exception.InvalidParamException;
import step3.domain.Amount;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;

public class LottoWinNumbersRequestDto {
    private static final String NOT_SAME_NUMBER = "담청번호와 동일 할 수 없습니다.";
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

    public void validContain(LottoNumber lottoNumber) {
        if (lottoNumbers.isContain(lottoNumber)) {
            throw new InvalidParamException(NOT_SAME_NUMBER);
        }
    }
}
