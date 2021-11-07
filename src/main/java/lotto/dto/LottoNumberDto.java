package lotto.dto;

import lotto.LottoNumber;

public class LottoNumberDto {
    private final int number;

    public LottoNumberDto(LottoNumber lottoNumber) {
        this.number = lottoNumber.getNumber();
    }

    public int getNumber() {
        return number;
    }
}
