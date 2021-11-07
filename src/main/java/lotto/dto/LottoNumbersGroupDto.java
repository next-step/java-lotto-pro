package lotto.dto;

import lotto.LottoNumbers;
import lotto.LottoNumbersGroup;

import java.util.List;

public class LottoNumbersGroupDto {
    private final List<LottoNumbers> lottoNumbersGroup;

    public LottoNumbersGroupDto(LottoNumbersGroup lottoNumbersGroup) {
        this.lottoNumbersGroup = lottoNumbersGroup.getLottoNumbersGroup();
    }

    public List<LottoNumbers> getLottoNumbersGroup() {
        return lottoNumbersGroup;
    }
}
