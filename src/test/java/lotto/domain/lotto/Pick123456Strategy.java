package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pick123456Strategy implements NumberPickStrategy {
    @Override
    public List<Lotto> pickNumbers(final int quantity) {
        return Stream.generate(this::generateNumbers)
                .map(Lotto::new)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    private List<Integer> generateNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
