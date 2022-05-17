package lotto.domain;

import lotto.view.InputView;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
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

    public List<LottoNumber> getReadOnlyLottoNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
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
