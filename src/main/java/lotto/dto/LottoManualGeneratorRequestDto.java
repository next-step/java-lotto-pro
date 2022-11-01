package lotto.dto;

import lotto.domain.ManualLottoGenerator;

public class LottoManualGeneratorRequestDto {

    private ManualLottoGenerator lottoGenerator;

    public LottoManualGeneratorRequestDto(String lottoNumbers) {
        this.lottoGenerator = new ManualLottoGenerator(lottoNumbers);
    }

    public ManualLottoGenerator getLottoGenerator() {
        return lottoGenerator;
    }
}
