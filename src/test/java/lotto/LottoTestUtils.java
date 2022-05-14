package lotto;

import static java.util.Arrays.stream;

import java.util.stream.Collectors;

public class LottoTestUtils {

    public static LottoNumbers lottoNumbers(int... numbers) {
        return new LottoNumbers(stream(numbers)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList()));
    }

}
