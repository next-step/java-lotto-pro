package lotto.model;

import static java.util.stream.Collectors.toList;
import static lotto.constants.LottoConstant.NUMBER_SIZE;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumber {
    private static final String LOTTO_NUMBER_FORMAT = "^([1-9]+[0-9]*,(\\s)*){5}[1-9]+[0-9]*$";
    private static final String DELIMITER = ",";

    private final List<Number> lottoNumber;

    protected LottoNumber(List<Number> lottoNumber) {
        validateDuplicate(lottoNumber);
        sortLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(List<Integer> lottoNumber) {
        List<Number> parseNumberList = lottoNumber.stream()
                .map(Number::of)
                .collect(toList());
        return new LottoNumber(parseNumberList);
    }

    public static LottoNumber of(String lottoNumber) {
        validateFormat(lottoNumber);
        return new LottoNumber(convertNumberList(lottoNumber));
    }

    private static List<Number> convertNumberList(String lottoNumber) {
        return split(lottoNumber).stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(toList());
    }

    public LottoRank getLottoRank(LottoNumber winningLottoNumber) {
        int count = (int) lottoNumber.stream()
                .filter(winningLottoNumber::isContainNumber)
                .count();
        return LottoRank.findByHits(count);
    }

    private boolean isContainNumber(Number number) {
        return this.lottoNumber.contains(number);
    }

    private static void validateDuplicate(List<Number> lottoNumber) {
        Set<Number> numberSet = new HashSet<>(lottoNumber);
        if (numberSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 중복은 허용되지 않습니다.");
        }
    }

    public static void sortLottoNumber(List<Number> lottoNumber) {
        lottoNumber.sort(Comparator.comparing(Number::getNumber));
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

    public List<Number> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
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
