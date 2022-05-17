package lotto;

import lotto.vo.Lottery;
import lotto.vo.Number;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LotteryProducer {
    private final List<Number> numbers = new LinkedList<>();

    public LotteryProducer() {
        for (int idx = Lottery.MINIMUM_NUMBER; idx < Lottery.MAXIMUM_NUMBER; idx ++) {
            numbers.add(new Number(idx));
        }
    }

    public List<Number> issue() {
        Collections.shuffle(this.numbers);
        List<Number> numbers = new LinkedList<>(this.numbers.subList(0, Lottery.SIZE));
        return readOnly(sort(numbers));
    }

    private List<Number> sort(List<Number> numbers) {
        numbers.sort(Comparator.comparingInt(Number::value));
        return numbers;
    }

    private List<Number> readOnly(List<Number> numbers) {
        return Collections.unmodifiableList(new LinkedList<>(numbers));
    }
}
