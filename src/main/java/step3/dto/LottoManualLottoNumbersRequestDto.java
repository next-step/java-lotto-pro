package step3.dto;

import java.util.ArrayList;
import java.util.List;

import step3.domain.strategy.numbers.ManualLottoNumbers;
import step3.domain.strategy.numbers.NumbersStrategy;

public class LottoManualLottoNumbersRequestDto {
    private final List<NumbersStrategy> manualLottoNumbers = new ArrayList<>();

    public void add(int[] readLineToArray) {
        manualLottoNumbers.add(new ManualLottoNumbers(readLineToArray));
    }

    public List<NumbersStrategy> getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
