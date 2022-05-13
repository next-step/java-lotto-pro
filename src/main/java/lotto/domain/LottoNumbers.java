package lotto.domain;

import static lotto.constants.LottoErrorMessage.MUST_BE_UNIQUE_NUMBER;
import static lotto.constants.LottoNumberConstants.LOTTO_NUMBER_SIZE;

import generator.NumberGenerator;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers generateBy(NumberGenerator numberGenerator) {
        List<Integer> generateNumbers = numberGenerator.generate();
        List<LottoNumber> parsedLottoNumbers = parseIntegerToLottoNumber(generateNumbers);
        validateLottoNumbers(parsedLottoNumbers);
        return new LottoNumbers(parsedLottoNumbers);
    }

    public static LottoNumbers generateBy(List<Integer> numbers) {
        List<LottoNumber> parsedLottoNumbers = parseIntegerToLottoNumber(numbers);
        validateLottoNumbers(parsedLottoNumbers);
        return new LottoNumbers(parsedLottoNumbers);
    }

    private static void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format(MUST_BE_UNIQUE_NUMBER, lottoNumbers));
        }
    }

    private static List<LottoNumber> parseIntegerToLottoNumber(List<Integer> generateNumbers) {
        return generateNumbers.stream()
            .filter(Objects::nonNull)
            .map(LottoNumber::from)
            .collect(Collectors.toList());
    }

    public List<LottoNumber> getReadOnlyLottoNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList())
            .toString();
    }
}
