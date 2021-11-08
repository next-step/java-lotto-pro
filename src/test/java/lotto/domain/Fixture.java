package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Fixture {
    private Fixture() {
    }

    public static LottoNumbers lottoNumbersOf(int... numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.collectingAndThen(Collectors.toSet(), LottoNumbers::new));
    }
}
