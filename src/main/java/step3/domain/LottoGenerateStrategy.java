package step3.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {
    List<Integer> generate();
}
