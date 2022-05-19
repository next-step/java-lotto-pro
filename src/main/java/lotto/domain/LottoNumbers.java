package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static LottoNumbers generateLottoNumbers(NumbersGenerator numbersGenerator) {
        List<Integer> generateNumbers = numbersGenerator.generate();
        Collections.sort(generateNumbers);
        List<LottoNumber> parsedLottoNumbers = parseIntegerToLottoNumber(generateNumbers);

        return new LottoNumbers(parsedLottoNumbers);
    }

    public static LottoNumbers generateLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        List<LottoNumber> parsedLottoNumbers = parseIntegerToLottoNumber(numbers);

        return new LottoNumbers(parsedLottoNumbers);
    }

    public static LottoNumbers from(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> getReadOnlyLottoNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    public boolean notContains(LottoNumber lottoNumber) {
        return !this.lottoNumbers.contains(lottoNumber);
    }

    public static List<Integer> getLottoNumbersFromInput(String receivedLottoNumbers) {
        return LottoNumbersGenerator.generate(receivedLottoNumbers);
    }

    private static List<LottoNumber> parseIntegerToLottoNumber(List<Integer> generateNumbers) {
        return generateNumbers.stream()
                .filter(Objects::nonNull)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
