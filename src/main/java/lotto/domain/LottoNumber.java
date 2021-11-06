package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 로또 번호를 발급하는 역할을 가진 클래스
public class LottoNumber {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LottoProperty.LOTTO_START_NUMBER, LottoProperty.LOTTO_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private LottoNumber() {
    }

    public static List<Integer> generator() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.stream()
                .limit(LottoProperty.LOTTO_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
