package step3.model.machine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import step3.model.util.InputValidation;
import step3.model.value.ErrMsg;
import step3.model.value.Rule;

public class LottoManualGenerator {
    public List<Integer> createLotto(String lottoManualInput) {
        InputValidation.validateEmpty(lottoManualInput);
        List<Integer> lottoNumbers = splitLottoNumbers(lottoManualInput);
        verifyLotto(lottoNumbers);
        return lottoNumbers;
    }

    private void verifyLotto(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != Rule.LOTTO_NUMBER_LENGTH){
            throw new IllegalArgumentException(ErrMsg.WRONG_LENGTH);
        }
        if(lottoNumbers.size() != new HashSet<>(lottoNumbers).size()){
            throw new IllegalArgumentException(ErrMsg.DUPLICATED_INPUT);
        }
    }

    private List<Integer> splitLottoNumbers(String lottoManualInput) {
        return Arrays.stream(lottoManualInput.split(Rule.DELIMITER))
                .map(this::changeToInt).collect(Collectors.toList());
    }
    private Integer changeToInt(String input){
        String trimInput = input.trim();
        InputValidation.validateEmpty(trimInput);
        InputValidation.validateNumber(trimInput);
        return Integer.parseInt(trimInput);
    }
}
