package lotto;

import lotto.exception.WrongLottoNumberSizeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    private static final String WRONG_LOTTO_NUMBER_SIZE_MESSAGE = "입력하신 로또의 개수를 확인 해 주세요.";
    public static final String LOTTO_NUMBERS_BASE_SEPARATOR = ",";
    public static final String FIND_ALL_SPACES = "\\s+";
    public static final String REMOVE_SPACES = "";
    public static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> randomLottoNumberPocket = generateRandomLottoNumberPocket();

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = generateRandomLottoNumbers();
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String lottoNumbersString) {
        this(lottoNumbersString, LOTTO_NUMBERS_BASE_SEPARATOR);
    }

    public LottoNumbers(String lottoNumbers, String separator) {
        this.lottoNumbers = new HashSet<>();
        generateLottoNumbersFromString(lottoNumbers, separator);
    }

    private static List<LottoNumber> generateRandomLottoNumberPocket() {
        List<LottoNumber> resultPocket = new ArrayList<>();
        for (int number = LottoNumber.MIN_BOUND; number <= LottoNumber.MAX_BOUND; number++) {
            resultPocket.add(new LottoNumber(number));
        }

        return resultPocket;
    }

    private Set<LottoNumber> generateRandomLottoNumbers() {
        Collections.shuffle(randomLottoNumberPocket);

        return new HashSet<>(randomLottoNumberPocket.subList(0, LOTTO_SIZE));
    }

    private void generateLottoNumbersFromString(String lottoNumbers, String separator) {
        lottoNumbers = lottoNumbers.replaceAll(FIND_ALL_SPACES, REMOVE_SPACES);
        String[] splitLottoNumbers = lottoNumbers.split(separator);
        validateLottoNumbers(splitLottoNumbers);
        for (String lottoNumberString : splitLottoNumbers) {
            this.lottoNumbers.add(new LottoNumber(lottoNumberString));
        }
    }

    private void validateLottoNumbers(String[] splitLottoNumbers) {
        if (splitLottoNumbers.length != LOTTO_SIZE) {
            throw new WrongLottoNumberSizeException(WRONG_LOTTO_NUMBER_SIZE_MESSAGE);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
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
}
