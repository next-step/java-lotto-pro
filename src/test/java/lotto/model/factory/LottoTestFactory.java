package lotto.model.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.lotto.Lotto;

public class LottoTestFactory implements ILottoFactory {

    @Override
    public List<Lotto> generateAuto(int lottoCount) {
        return IntStream.rangeClosed(1, lottoCount)
            .mapToObj(operand -> Lotto.fromInteger(Arrays.asList(1, 2, 3, 4, 5, 6)))
            .collect(Collectors.toList());
    }

}
