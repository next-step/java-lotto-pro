package model;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static model.LottoNumber.MAXIMUM_RANGE_NUMBER;
import static model.LottoNumber.MINIMUM_RANGE_NUMBER;

public class LottoNumberGenerator {

    public Set<LottoNumber> generate(Number number) {
        List<Integer> lottoNumbers = IntStream.rangeClosed(MINIMUM_RANGE_NUMBER, MAXIMUM_RANGE_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6).stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
