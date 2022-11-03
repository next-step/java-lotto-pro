package lotto.generate;

import lotto.constant.LottoConstant;
import lotto.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberGenerator {
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final List<LottoNumber> availableLottoNumbers;

    static {
        availableLottoNumbers = Stream
                .iterate(LottoConstant.MIN_LOTTO_NUMBER, n -> n + 1)
                .map(LottoNumber::new)
                .limit(LottoConstant.MAX_LOTTO_NUMBER)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> generate() {
        Collections.shuffle(availableLottoNumbers);
        return availableLottoNumbers.stream()
                .limit(LottoConstant.LOTTO_COMPONENT_COUNT)
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public static List<LottoNumber> generateManulLotto(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(LOTTO_NUMBER_DELIMITER))
                .map(LottoNumber::new).distinct()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

    }
}
