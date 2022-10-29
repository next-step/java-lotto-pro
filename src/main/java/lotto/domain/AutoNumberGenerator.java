package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoNumberGenerator implements LottoNumberGenerator {
    @Override
    public Set<LottoNumber> generate() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(LottoNumber.MINIMUM_LOTTO_NUMBER, LottoNumber.MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
