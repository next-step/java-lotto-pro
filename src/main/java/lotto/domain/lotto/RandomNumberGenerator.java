package lotto.domain.lotto;

import java.util.List;

@FunctionalInterface
public interface RandomNumberGenerator {
    List<Integer> generate();
}
