package step3.model.machine;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import step3.model.lotto.LottoNumber;
import step3.model.value.Rule;

public class ShuffleLottoGenerator implements LottoAutoGenerator {

    @Override
    public List<LottoNumber> generateLottoAuto() {
        List<Integer> numbers = IntStream.rangeClosed(Rule.MIN_LOTTO_NUM, Rule.MAX_LOTTO_NUM)
                .boxed()
                .collect(toList());
        Collections.shuffle(numbers);
        return numbers.subList(Rule.AUTO_GENERATE_START_NUM, Rule.AUTO_GENERATE_END_NUM)
                .stream().map(LottoNumber::new).collect(toList());
    }
}

