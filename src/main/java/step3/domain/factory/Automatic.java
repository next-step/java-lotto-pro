package step3.domain.factory;

import step3.domain.lotto.LottoNumbers;
import step3.domain.lotto.LottoType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.domain.lotto.LottoNumber.END_INCLUSIVE;
import static step3.domain.lotto.LottoNumber.START_INCLUSIVE;
import static step3.domain.lotto.LottoNumbers.DEFAULT_LOTTO_SIZE;

public class Automatic implements LottoFactory {

    @Override
    public LottoNumbers create() {
        return new LottoNumbers(pickNumberInRange());
    }

    @Override
    public LottoType getLottoType() {
        return LottoType.AUTOMATIC;
    }

    private List<Integer> pickNumberInRange() {
        List<Integer> integers = IntStream.range(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);
        return integers.subList(0, DEFAULT_LOTTO_SIZE);
    }
}
