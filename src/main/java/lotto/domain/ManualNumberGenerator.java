package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.view.OutputView;

public class ManualNumberGenerator implements LottoNumberGenerator {
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private Set<LottoNumber> lottoNumbers;

    public ManualNumberGenerator(String input) {
        try {
            String[] split = input.split(LOTTO_NUMBER_DELIMITER);
            Set<LottoNumber> numbers = Arrays.stream(split)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .distinct()
                    .map(LottoNumber::new)
                    .collect(Collectors.toSet());
            validDuplicate(numbers.size(), split.length);
            this.lottoNumbers = numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_INPUT_MANUAL_LOTTO_NUMBER);
        }
    }

    private void validDuplicate(int numberSize, int inputSize) {
        if (numberSize != inputSize) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_INPUT_MANUAL_NUMBER_DUPLICATE);
        }
    }

    @Override
    public Set<LottoNumber> generate() {
        return this.lottoNumbers;
    }
}