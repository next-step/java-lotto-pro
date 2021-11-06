package lotto.model;

import java.util.Set;

@FunctionalInterface
public interface NumberSupplier {
    Set<Number> getNumbers();
}
