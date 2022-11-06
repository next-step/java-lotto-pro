package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberManualGenerator implements NumberGenerator {

    private static final String SPLIT_DELIMITER = ",";
    private final String inputNumbers;

    public LottoNumberManualGenerator(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    @Override
    public List<Number> generate() {
        return Arrays.stream(inputNumbers.split(SPLIT_DELIMITER))
                .map(it -> new LottoNumber(it.trim()))
                .collect(Collectors.toList());
    }
}
