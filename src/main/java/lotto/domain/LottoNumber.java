package lotto.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final Map<Integer, LottoNumber> lottoNumberMap = IntStream.rangeClosed(MIN, MAX)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), LottoNumber::new));

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validate(number);
        return lottoNumberMap.get(number);
    }

    private static void validate(int number) {
        if(MIN > number || number > MAX) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하의 숫자만 가능합니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber number) {
        return this.number - number.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
