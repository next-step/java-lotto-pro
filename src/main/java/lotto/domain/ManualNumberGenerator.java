package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualNumberGenerator implements LottoNumberGenerator {
    Set<LottoNumber> lottoNumbers;

    public ManualNumberGenerator(String input) {
        String[] split = input.split(",");
        Set<LottoNumber> numbers = Arrays.stream(split)
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        validDuplicate(numbers.size(), split.length);
        this.lottoNumbers = numbers;
    }

    private void validDuplicate(int numberSize, int inputSize) {
        if (numberSize != inputSize) {
            throw new IllegalArgumentException("중복 된 숫자가 있습니다.");
        }
    }

    @Override
    public Set<LottoNumber> generate() {
        return this.lottoNumbers;
    }
}