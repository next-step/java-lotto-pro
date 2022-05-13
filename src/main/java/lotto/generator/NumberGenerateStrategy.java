package lotto.generator;

import java.util.List;

@FunctionalInterface
public interface NumberGenerateStrategy {
    List<Integer> generate();
}
