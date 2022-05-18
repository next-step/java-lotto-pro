package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final List<Number> numbers = new ArrayList<>();

    public Lotto(int[] numbers) {
        checkSize(numbers);
        Arrays.stream(numbers).forEach(this::addNumber);
    }

    public Lotto(String[] numbers) {
        this(Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray());
    }

    public Lotto(List<Number> numbers) {
        this.numbers.addAll(numbers);
    }

    public int getCount(Lotto winningLotto) {
        int count = 0;
        for (Number number : winningLotto.getNumber()) {
            count += plusCount(number);
        }
        return count;
    }

    private int plusCount(Number number) {
        if(this.numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private void checkSize(int[] numbers) {
        if (numbers.length != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자의 개수가 맞지 않습니다.");
        }
    }

    private void addNumber(int number) {
        if(isContains(number)) {
            throw new IllegalArgumentException("중복된 숫자는 사용할 수 없습니다.");
        }
        this.numbers.add(new Number(number));
    }

    private boolean isContains(int number) {
        return numbers.contains(new Number(number));
    }

    public List<Integer> getNumberValues() {
        return numbers.stream().map(Number::getValue).sorted().collect(Collectors.toList());
    }

    public List<Number> getNumber() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(getNumberValues());
    }

}
