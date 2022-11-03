package step3.model.machine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import step3.model.lotto.Lotto;
import step3.model.lotto.LottoNumber;
import step3.model.util.InputValidation;
import step3.model.value.Rule;

public class LottoManualGenerator {
    public Lotto createLotto(String lottoManualInput) {
        InputValidation.validateEmpty(lottoManualInput);
        List<LottoNumber> lottoNumbers = splitLottoNumbers(lottoManualInput);
        return new Lotto(lottoNumbers);
    }

    private List<LottoNumber> splitLottoNumbers(String lottoManualInput) {
        return Arrays.stream(lottoManualInput.split(Rule.DELIMITER))
                .map(this::changeToInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
    private Integer changeToInt(String input){
        String trimInput = input.trim();
        InputValidation.validateEmpty(trimInput);
        InputValidation.validateNumber(trimInput);
        return Integer.parseInt(trimInput);
    }

}
