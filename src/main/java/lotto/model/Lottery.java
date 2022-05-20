package lotto.model;

import java.util.*;

public class Lottery {
    public final static int MINIMUM_NUMBER = 1;
    public final static int MAXIMUM_NUMBER = 45;
    public final static int SIZE = 6;

    private final static String LOTTERY_NUMBERS_WERE_NOT_GENERATED = "로또 번호가 생성되지 않았습니다.";

    private List<Number> numbers;

    public Lottery(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        if (isNull(numbers)) {
            throw new NullPointerException(LOTTERY_NUMBERS_WERE_NOT_GENERATED);
        }
        if (isCorrectSize(numbers)) {
            throw new IllegalArgumentException(LOTTERY_NUMBERS_WERE_NOT_GENERATED);
        }
    }

    private boolean isNull(List<Number> numbers) {
        return numbers == null;
    }

    private boolean isCorrectSize(List<Number> numbers) {
        Set<Number> set = new HashSet<>(numbers);
        return set.size() < SIZE || set.size() > SIZE;
    }

    public List<Number> list() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(numbers, lottery.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "numbers=" + numbers +
                '}';
    }
}
