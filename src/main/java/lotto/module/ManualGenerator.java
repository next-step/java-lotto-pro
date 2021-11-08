package lotto.module;

import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class ManualGenerator implements NumberGeneratorStrategy {
    private List<String> manualLottoNumber;

    public ManualGenerator(List<String> manualLottoNumber) {
        this.manualLottoNumber = manualLottoNumber;
    }

    @Override
    public List<LottoNumbers> createLottos() {
        return manualLottoNumber.stream()
                .map(this::generateManualLottoNumbers)
                .collect(Collectors.toList());
    }

    private LottoNumbers generateManualLottoNumbers(String lottoNumber) {
        return LottoNumbers.fromString(lottoNumber);
    }
}
