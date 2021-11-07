package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 로또 번호를 발급하는 역할을 가진 클래스
public class LottoNumber {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private LottoNumber() {
    }

    public static List<Integer> generator() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.stream()
                .limit(Lotto.LOTTO_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
