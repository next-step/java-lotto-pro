package lotto.domain.number;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class LottoNumber extends Number {
    private static final String LOTTO_NUMBER_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT = "번호의 값이 null이거나 빈 값입니다.";
    private static final String LOTTO_NUMBER_IS_OUT_OF_BOUND_EXCEPTION_STATEMENT = "번호의 범위를 벗어났습니다.";

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    public static final Map<Integer, LottoNumber> LOTTO_NUMBER_COLLECTION =
        IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toMap(Number::number, Function.identity()));

    private LottoNumber(int number) {
        super(number);
        validate(number);
    }

    public static LottoNumber from(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT);
        }
        return LOTTO_NUMBER_COLLECTION.get(Integer.valueOf(number));
    }

    public static LottoNumber from(int number) {
        if (!LOTTO_NUMBER_COLLECTION.containsKey(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_OUT_OF_BOUND_EXCEPTION_STATEMENT);
        }
        return LOTTO_NUMBER_COLLECTION.get(number);
    }

    @Override
    protected void validate(int number) {
        if (number < LOTTO_NUMBER_MIN || LOTTO_NUMBER_MAX < number) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_OUT_OF_BOUND_EXCEPTION_STATEMENT);
        }
    }
}
