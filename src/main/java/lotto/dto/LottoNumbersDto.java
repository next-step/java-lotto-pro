package lotto.dto;

import java.util.*;
import java.util.stream.*;

import lotto.domain.number.Number;
import lotto.domain.ticket.*;

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
