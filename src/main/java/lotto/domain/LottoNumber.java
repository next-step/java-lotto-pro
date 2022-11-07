package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final String EXCEPTION_MESSAGE_FOR_OUT_OF_LOTTO_NUMBER_BOUNDARY = "로또번호는 " + MINIMUM_LOTTO_NUMBER + "과 " + MAXIMUM_LOTTO_NUMBER + "사이의 숫자이어야 합니다.";
    private static final Map<Integer, LottoNumber> lottoNumberMap = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toMap(LottoNumber::lottoNumber, e -> e));
    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_OUT_OF_LOTTO_NUMBER_BOUNDARY);
        }
    }

    public int lottoNumber() {
        return this.lottoNumber;
    }

    public static Map<Integer, LottoNumber> lottoNumberMap() {
        return Collections.unmodifiableMap(lottoNumberMap);
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNumberMap.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int compareTo(Object lottoNumber) {
        return Integer.compare(this.lottoNumber, ((LottoNumber) lottoNumber).lottoNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
