package lotto.model;

import java.util.Set;

import lotto.model.dto.Number;

@FunctionalInterface
public interface NumberSupplier {
    Set<Number> getNumbers();
}
