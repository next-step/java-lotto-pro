package lotto.dto;

import lotto.LottoNumber;
import lotto.LottoNumbers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbersDto {
    private final Set<LottoNumberDto> lottoNumbers;

    public LottoNumbersDto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers.getLottoNumbers()
                .stream()
                .map(LottoNumberDto::new)
                .collect(Collectors.toSet());
    }

    public List<LottoNumberDto> getSortedLottoNumbers() {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
