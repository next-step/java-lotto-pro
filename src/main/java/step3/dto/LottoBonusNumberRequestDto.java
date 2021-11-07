package step3.dto;

import step3.domain.LottoNumber;

public class LottoBonusNumberRequestDto {
    private final LottoNumber lottoNumber;

    public LottoBonusNumberRequestDto(int number) {
        this.lottoNumber = new LottoNumber(number);
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }
}
