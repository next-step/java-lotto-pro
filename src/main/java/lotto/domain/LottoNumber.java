package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private static final List<LottoNumber> CACHES = IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber get(int index) {
        validate(index);
        return CACHES.get(index - 1);
    }

    private static void validate(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 %d과 %d 사이여야 합니다.", LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            );
        }
    }

    public int getNumber() {
        return this.number;
    }
}
