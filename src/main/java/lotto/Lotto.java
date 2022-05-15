package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final List<Number> numbers = new ArrayList<>();

    public Lotto(int[] numbers) {
        if(!isEqualSize(numbers)) {
            throw new IllegalArgumentException("숫자의 개수가 맞지 않습니다.");
        }
        Arrays.stream(numbers).forEach(this::addNumber);
    }

    public Lotto(List<Number> numbers) {
        this.numbers.addAll(numbers);
    }

    private boolean isEqualSize(int[] numbers) {
        return numbers.length == NUMBER_SIZE;
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

    public List<Number> getNumbers() {
        return numbers;
    }

}
