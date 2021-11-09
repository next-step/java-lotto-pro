package step3.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class LottoNumber {
    private final int number;
    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();

    static {
        for (int i = LottoConstant.MIN_NUMBER_RANGE; i <= LottoConstant.MAX_NUMBER_RANGE; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        validRange(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNos.get(number))
            .orElseThrow(InvalidParamException::new);
    }

    public Integer value() {
        return number;
    }

    private void validRange(int number) {
        if (isArrowedRange(number)) {
            throw new InvalidParamException(LottoConstant.LOTTO_RANGE_OVER_EXCEPTION);
        }
    }

    private boolean isArrowedRange(int number) {
        return number < LottoConstant.MIN_NUMBER_RANGE || number > LottoConstant.MAX_NUMBER_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumber that = (LottoNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
