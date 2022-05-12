package lotto;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;
import lotto.constants.LottoErrorMessage;

public class LottoNumber implements LottoNumberInterface {
    protected static final List<Integer> NUMBER_RANGE = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
            .boxed()
            .collect(toList());
    private static final String LOTTO_NUMBER_FORMAT = "^([1-9]+[0-9]*,(\\s)*){5}[1-9]+[0-9]*$";
    private static final String DELIMITER = ",";
    private final List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        validateDuplicate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(String lottoNumber) {
        validateFormat(lottoNumber);
        List<Integer> convertLottoNumber = convertList(lottoNumber);
        validateDuplicate(convertLottoNumber);
        this.lottoNumber = convertLottoNumber;
    }

    public LottoRank getLottoRank(LottoNumber winningLottoNumber) {
        int count = (int) lottoNumber.stream()
                .filter(winningLottoNumber::isContainNumber)
                .count();
        return LottoRank.findByHits(count);
    }

    private boolean isContainNumber(int number) {
        return this.lottoNumber.contains(number);
    }

    private List<Integer> convertList(String lottoNumber) {
        List<String> numberList = split(lottoNumber);
        return numberList.stream()
                .map(String::trim)
                .map(LottoNumber::parseLottoNumber)
                .collect(toList());
    }

    private static int parseLottoNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        validateNumberRange(number);
        return number;
    }

    private void validateDuplicate(List<Integer> lottoNumber) {
        Set<Integer> numberSet = new HashSet<>(lottoNumber);
        if (numberSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private static void validateNumberRange(int number) {
        if (!NUMBER_RANGE.contains(number)) {
            throw new IllegalArgumentException(LottoErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }

    private List<String> split(String lottoNumber) {
        return Arrays.asList(lottoNumber.split(DELIMITER));
    }

    private static void validateFormat(String winningNumber) {
        if (isNotValid(winningNumber)) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_FORMAT);
        }
    }

    private static boolean isNotValid(String winningNumber) {
        return isNull(winningNumber) || isInvalidFormat(winningNumber);
    }

    private static boolean isInvalidFormat(String winningNumber) {
        return !winningNumber.matches(LOTTO_NUMBER_FORMAT);
    }

    private static boolean isNull(String winningNumber) {
        return winningNumber == null;
    }

    @Override
    public List<Integer> getLottoNumber() {
        sortLottoNumber();
        return lottoNumber;
    }

    @Override
    public void sortLottoNumber() {
        Collections.sort(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
