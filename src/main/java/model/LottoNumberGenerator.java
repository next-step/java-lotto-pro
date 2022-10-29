package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public List<LottoNumber> generate(Number number) {
        List<Integer> lottoNumbers = IntStream.rangeClosed(number.getMinimumRangeNumber(), number.getMaximumRangeNumber())
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6).stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
