package step3.domain.generator;

import step3.domain.lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.domain.lotto.LottoNumber.END_INCLUSIVE;
import static step3.domain.lotto.LottoNumber.START_INCLUSIVE;
import static step3.domain.lotto.LottoNumbers.DEFAULT_LOTTO_SIZE;

public class Random implements LottoFactory {

    @Override
    public List<LottoNumber> create() {
        return pickNumberInRange().stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private List<Integer> pickNumberInRange() {
        List<Integer> integers = IntStream.range(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);
        return integers.subList(0, DEFAULT_LOTTO_SIZE);
    }
}
