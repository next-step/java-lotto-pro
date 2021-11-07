package lotto.dto;

import lotto.domain.LottoNumber;

public class LottoNumberDto implements Comparable<LottoNumberDto> {
    private final int number;

    public LottoNumberDto(LottoNumber lottoNumber) {
        this.number = lottoNumber.getNumber();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumberDto otherNumberDto) {
        return number - otherNumberDto.number;
    }
}
