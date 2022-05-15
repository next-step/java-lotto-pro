package lotto;

import lotto.vo.Number;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LotteryUtils {
    private final static String LOTTERY_NUMBERS_MUST_BE_POSITIVE_INTEGERS = "로또 번호는 1보다 작을 수 없습니다.";
    private final static String LOTTERY_NUMBERS_COUNT_MUST_BE_AT_LEAST_SIX = "로또 번호 개수는 6개 이상입니다.";

    private final LinkedList<Number> numbers = new LinkedList<>();

    public LotteryUtils(int number, int creationCount) {
        if (number < 1) {
            throw new IllegalArgumentException(LOTTERY_NUMBERS_MUST_BE_POSITIVE_INTEGERS);
        }
        if (creationCount < 6) {
            throw new IllegalArgumentException(LOTTERY_NUMBERS_COUNT_MUST_BE_AT_LEAST_SIX);
        }
        while (number <= creationCount) {
            numbers.add(new Number(number++));
        }
    }

    public List<Number> pickRandomNumbers(int pickCount) {
        Collections.shuffle(this.numbers);
        List<Number> numbers = this.numbers.subList(0, pickCount);
        return sort(numbers);
    }

    private List<Number> sort(List<Number> numbers) {
        numbers.sort(Comparator.comparingInt(Number::value));
        return numbers;
    }
}
