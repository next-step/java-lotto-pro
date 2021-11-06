package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final String LOTTO_NUMBERS_BASE_SEPARATOR = ",";
    public static final String LOTTO_NUMBERS_DESCRIPTION_OPEN_BRACKET = "[";
    public static final String LOTTO_NUMBERS_DESCRIPTION_CLOSE_BRACKET = "]";
    public static final String LOTTO_NUMBERS_DESCRIPTION_SPACE = " ";
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = new HashSet<>();
        generateRandomLottoNumbers();
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String lottoNumbersString) {
        this(lottoNumbersString, LOTTO_NUMBERS_BASE_SEPARATOR);
    }

    public LottoNumbers(String lottoNumbersString, String separator) {
        this.lottoNumbers = new HashSet<>();
        generateLottoNumbersFromString(lottoNumbersString, separator);
    }

    private void generateRandomLottoNumbers() {
        List<LottoNumber> RandomLottoNumberPocket = new ArrayList<>();
        for (int number = LottoNumber.MIN_BOUND; number <= LottoNumber.MAX_BOUND; number++) {
            RandomLottoNumberPocket.add(new LottoNumber(number));
        }
        Collections.shuffle(RandomLottoNumberPocket);
        for (int index = 0; index < LOTTO_SIZE; index++) {
            LottoNumber randomNumber = RandomLottoNumberPocket.get(index);
            lottoNumbers.add(randomNumber);
        }
    }

    private void generateLottoNumbersFromString(String lottoNumbersString, String separator) {
        String[] splitLottoNumbersString = lottoNumbersString.split(separator);
        for (String lottoNumberString : splitLottoNumbersString) {
            lottoNumbers.add(new LottoNumber(lottoNumberString));
        }
    }

    public boolean containsNumber(LottoNumber myLottoNumber) {
        return lottoNumbers.contains(myLottoNumber);
    }

    public int getMatchCount(LottoNumbers prizeLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(prizeLottoNumbers::containsNumber)
                .count();
    }

    public LottoResult getLottoResult(LottoNumbers prizeLottoNumbers) {
        return new LottoResult(getMatchCount(prizeLottoNumbers));
    }

    private void addElementForMakingString(StringBuilder result, Set<LottoNumber> lottoNumbers) {
        List<LottoNumber> sortedLottoNumbers = lottoNumbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .collect(Collectors.toList());
        int index = 0;
        int lastIndex = sortedLottoNumbers.size() - 1;
        for (LottoNumber lottoNumber : sortedLottoNumbers) {
            result.append(lottoNumber.toString());
            if (index == lastIndex) {
                break;
            }
            result.append(LOTTO_NUMBERS_BASE_SEPARATOR)
                    .append(LOTTO_NUMBERS_DESCRIPTION_SPACE);
            index++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(LOTTO_NUMBERS_DESCRIPTION_OPEN_BRACKET);
        addElementForMakingString(result, lottoNumbers);
        result.append(LOTTO_NUMBERS_DESCRIPTION_CLOSE_BRACKET);
        return result.toString();
    }
}
