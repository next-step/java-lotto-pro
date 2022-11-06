package lotto.domain;

import static lotto.domain.Lotto.NUMBER_COUNT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ManualLottoInput {
    public static final String DELIMITER_COMMA = ",";
    public static final String ONLY_NUMBER_REGEX = "^\\d*$";
    private List<String> inputNumbers;
    private ManualLottoInput(){}
    public static ManualLottoInput create(String input) {
        ManualLottoInput manualLottoInput = new ManualLottoInput();
        manualLottoInput.inputNumbers = Arrays.asList(input.split(DELIMITER_COMMA));

        validateOnlyNumber(manualLottoInput.inputNumbers);
        validateCount(manualLottoInput.inputNumbers);
        validateDuplicateNumber(manualLottoInput.inputNumbers);

        return manualLottoInput;
    }

    private static void validateOnlyNumber(List<String> inputNumbers) {
        inputNumbers.forEach(number -> {
                    if(!Pattern.matches(ONLY_NUMBER_REGEX, number)){
                        throw new IllegalArgumentException("숫자만 올 수 있습니다.");
                    }
                });
    }

    private static void validateCount(List<String> inputNumbers) {
        if(inputNumbers.size() != NUMBER_COUNT){
            throw new IllegalArgumentException("입력받은 숫자는 6개여야 합니다.");
        }
    }

    private static void validateDuplicateNumber(List<String> inputNumbers) {
        Set<String> convertSet = new HashSet<>(inputNumbers);
        if(convertSet.size() != inputNumbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public List<Integer> convertIntegers() {
        return this.inputNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
