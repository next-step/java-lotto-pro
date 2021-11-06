package lotto.dto;

import lotto.domain.number.Number;
import lotto.domain.ticket.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersDto {
    private final List<Integer> lottoNumbersDto;

    private LottoNumbersDto(LottoNumbers lottoNumbers) {
        lottoNumbersDto = lottoNumbers.lottoNumbers()
            .stream()
            .map(Number::number)
            .collect(Collectors.toList());
    }

    public static LottoNumbersDto from(LottoNumbers lottoNumbers) {
        return new LottoNumbersDto(lottoNumbers);
    }

    public List<Integer> getLottoNumbersDto() {
        return lottoNumbersDto;
    }
}
