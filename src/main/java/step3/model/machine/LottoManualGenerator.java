package step3.model.machine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import step3.model.lotto.LottoNumber;
import step3.model.util.InputValidation;
import step3.model.value.Rule;

public class LottoManualGenerator {
    public List<LottoNumber> createLotto(String lottoManualInput) {
        InputValidation.validateEmpty(lottoManualInput);
        return splitLottoNumbers(lottoManualInput);
    }

    private List<LottoNumber> splitLottoNumbers(String lottoManualInput) {
        return Arrays.stream(lottoManualInput.split(Rule.DELIMITER))
                .map(this::changeToInt).map(LottoNumber::new).collect(Collectors.toList());
    }
    private Integer changeToInt(String input){
        String trimInput = input.trim();
        InputValidation.validateEmpty(trimInput);
        InputValidation.validateNumber(trimInput);
        return Integer.parseInt(trimInput);
    }

}
