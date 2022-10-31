package step3.model.machine;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import step3.model.lotto.Lotto;
import step3.model.value.Rule;

public class ShuffleLottoGenerator implements LottoAutoGenerator {

    @Override
    public List<Integer> generateLottoAuto(int count) {
        List<Integer> numbers = IntStream.rangeClosed(Rule.MIN_LOTTO_NUM, Rule.MAX_LOTTO_NUM)
                .boxed()
                .collect(toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, count);
    }
}

