package lotto.domain.lotto.pick;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.LottoNumbers;

public class Pick123456Strategy implements NumberPickStrategy {
    @Override
    public Stream<LottoNumbers> pickNumbers(final int quantity) {
        return Stream.generate(this::generateNumbers)
                .limit(quantity)
                .map(LottoNumbers::new);
    }

    private List<Integer> generateNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
