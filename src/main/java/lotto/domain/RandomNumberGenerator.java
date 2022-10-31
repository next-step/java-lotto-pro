package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface RandomNumberGenerator {
    List<Integer> generate();
}
