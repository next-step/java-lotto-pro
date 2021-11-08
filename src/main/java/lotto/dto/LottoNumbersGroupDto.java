package lotto.dto;

import lotto.domain.LottoNumbersGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGroupDto {
    private final List<LottoNumbersDto> lottoNumbersGroup;

    public LottoNumbersGroupDto(LottoNumbersGroup lottoNumbersGroup) {
        this.lottoNumbersGroup = lottoNumbersGroup.getLottoNumbersGroup()
                .stream()
                .map(LottoNumbersDto::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumbersDto> getLottoNumbersGroup() {
        return lottoNumbersGroup;
    }
}
