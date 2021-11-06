package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberSupplier implements NumberSupplier {
    private static final int MIN_SIZE = 1;
    private static final String SIZE_ERR_MSG = "size 는 최소 " + MIN_SIZE + " 이상이어야 합니다.";
    private static final String NUMBER_RANGE_ERR_MSG = "startInclusive가 endInclusive보다 클 수 없습니다.";
    private static final String INVALID_ARGUMENTS_ERR_MSG =
        "반환되는 수는 서로 다른 수들로 이루어져야 하기 때문에 endInclusive - startInclusive + " + MIN_SIZE + " >= size 여야 합니다.";

    private final int size;
    private final int startInclusive;
    private final int endInclusive;

    private RandomNumberSupplier(int size, int startInclusive, int endInclusive) {
        this.size = size;
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        validate();
    }

    private void validate() {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException(SIZE_ERR_MSG);
        }
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERR_MSG);
        }
        if (endInclusive - startInclusive + MIN_SIZE < size) {
            throw new IllegalArgumentException(INVALID_ARGUMENTS_ERR_MSG);
        }
    }

    @Override
    public Set<Number> getNumbers() {
        List<Number> numbers = new ArrayList<>();
        for (int i = startInclusive; i <= endInclusive; i++) {
            numbers.add(new Number(i));
        }
        Collections.shuffle(numbers);
        Set<Number> chosenNumbers = new HashSet<>(numbers.subList(0, size));
        return Collections.unmodifiableSet(chosenNumbers);
    }

    public static class RandomNumberSupplierBuilder {
        private int size;
        private int startInclusive;
        private int endInclusive;

        public RandomNumberSupplierBuilder withSize(int size) {
            this.size = size;
            return this;
        }

        public RandomNumberSupplierBuilder withRange(int startInclusive, int endInclusive) {
            this.startInclusive = startInclusive;
            this.endInclusive = endInclusive;
            return this;
        }

        public RandomNumberSupplier build() {
            return new RandomNumberSupplier(size, startInclusive, endInclusive);
        }
    }
}
