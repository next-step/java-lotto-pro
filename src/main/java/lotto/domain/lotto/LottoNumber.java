package lotto.domain.lotto;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN_LOTTO_BOUND = 1;
    public static final int MAX_LOTTO_BOUND = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_BOX = generate();

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int number) {
        LottoNumber lottoNumber = LOTTO_NUMBER_BOX.get(number);
        if (Objects.isNull(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 까지 입니다.");
        }
        return lottoNumber;
    }

    private static Map<Integer, LottoNumber> generate() {
        return IntStream.rangeClosed(MIN_LOTTO_BOUND, MAX_LOTTO_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toMap(
                        LottoNumber::getLottoNumber, Function.identity()
                ));
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
