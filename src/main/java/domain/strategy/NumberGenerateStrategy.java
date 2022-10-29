package domain.strategy;

import java.util.List;

public interface NumberGenerateStrategy {
    List<Integer> generate(List<Integer> numberPool, int size);
}
