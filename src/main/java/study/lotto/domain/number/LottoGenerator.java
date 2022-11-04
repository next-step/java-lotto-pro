package study.lotto.domain.number;

import study.lotto.domain.Lotto;
import study.lotto.domain.order.OrderType;
import study.message.LottoExceptionCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    private static Map<Integer, LottoNumber> cacheLottoNumbers = new HashMap<>();

    static {
        IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
                .forEach((num) -> cacheLottoNumbers.put(num, new LottoNumber(num)));
    }

    public static Lotto generate(List<Integer> numbers, OrderType orderType) {
        return new Lotto(numbers.stream()
                .map(LottoGenerator::toLottoNumber)
                .collect(Collectors.toSet()), orderType);
    }

    public static LottoNumber toLottoNumber(int number) {
        if(Objects.isNull(cacheLottoNumbers.get(number))) {
            throw new IllegalArgumentException(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
        }

        return cacheLottoNumbers.get(number);
    }
}
