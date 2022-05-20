package lotto.service;

import lotto.model.Lottery;
import lotto.model.Number;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LotteryProducer {
    private static final List<Number> numbers;

    static {
        numbers = new LinkedList<>();
        for (int idx = Lottery.MINIMUM_NUMBER; idx < Lottery.MAXIMUM_NUMBER; idx ++) {
            numbers.add(new Number(idx));
        }
    }

    public LotteryProducer() {
        for (int idx = Lottery.MINIMUM_NUMBER; idx < Lottery.MAXIMUM_NUMBER; idx ++) {
            numbers.add(new Number(idx));
        }
    }

    public static List<Number> issue() {
        Collections.shuffle(numbers);
        List<Number> subset = new LinkedList<>(numbers.subList(0, Lottery.SIZE));
        return readOnly(sort(subset));
    }

    private static List<Number> sort(List<Number> numbers) {
        numbers.sort(Comparator.comparingInt(Number::value));
        return numbers;
    }

    private static List<Number> readOnly(List<Number> numbers) {
        return Collections.unmodifiableList(new LinkedList<>(numbers));
    }
}
