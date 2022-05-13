package lotto.model;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final String LOTTO_NUMBER_FORMAT = "^([1-9]+[0-9]*,(\\s)*){5}[1-9]+[0-9]*$";
    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    protected static final List<Integer> NUMBER_RANGE = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
            .boxed()
            .collect(toList());
    protected static final int NUMBER_SIZE = 6;

    private final List<Integer> lottoNumber;

    protected LottoNumber(List<Integer> lottoNumber) {
        validateDuplicate(lottoNumber);
        sortLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(List<Integer> lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber of(String lottoNumber) {
        validateFormat(lottoNumber);
        return new LottoNumber(convertList(lottoNumber));
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

    private static List<Integer> convertList(String lottoNumber) {
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

    private static void validateDuplicate(List<Integer> lottoNumber) {
        Set<Integer> numberSet = new HashSet<>(lottoNumber);
        if (numberSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 중복은 허용되지 않습니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (!NUMBER_RANGE.contains(number)) {
            throw new IllegalArgumentException("로또 숫자 범위를 벗어났습니다.");
        }
    }

    private static List<String> split(String lottoNumber) {
        return Arrays.asList(lottoNumber.split(DELIMITER));
    }

    private static void validateFormat(String winningNumber) {
        if (isNotValid(winningNumber)) {
            throw new IllegalArgumentException("올바른 로또 번호 양식이 아닙니다.");
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

    public List<Integer> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
    }

    public static void sortLottoNumber(List<Integer> lottoNumber) {
        Collections.sort(lottoNumber);
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
