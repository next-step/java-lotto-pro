package domain.strategy;

import java.util.List;
import java.util.Set;

public interface NumberGenerateStrategy {
    Set<Integer> generate(List<Integer> numberPool, int size);
}
