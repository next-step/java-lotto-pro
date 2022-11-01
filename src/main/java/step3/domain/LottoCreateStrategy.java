package step3.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static step3.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

public interface LottoCreateStrategy {
    Map<Integer, LottoNumber> lottoNumberMap = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toMap(LottoNumber::lottoNumber, e -> e));

    Lotto createLotto();
}
