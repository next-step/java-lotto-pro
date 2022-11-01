package step3.domain;

import java.util.Set;

@FunctionalInterface
public interface NumberGenerateStrategy {
    Set<Integer> generate();
}
