package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final List<Number> numbers = new ArrayList<>();

    public Lotto(List<Number> numbers) {
        validationSize(numbers);
        this.numbers.addAll(numbers);
    }

    public Lotto(int[] inputs) {
        List<Number> numbers = Arrays.stream(inputs).mapToObj(Number::new).collect(toList());
        validationSize(numbers);
        numbers.forEach(this::addNumber);
    }

    public Lotto(String[] numbers) {
        this(Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray());
    }

    public int getCount(Lotto winningLotto) {
        return (int) winningLotto.getNumber().stream()
                .filter(numbers::contains)
                .count();
    }

    private void validationSize(List<Number> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("로또의 번호는 %d개만 가능합니다.", NUMBER_SIZE));
        }
    }

    private void addNumber(Number number) {
        if (isContains(number)) {
            throw new IllegalArgumentException("중복된 숫자는 사용할 수 없습니다.");
        }
        this.numbers.add(number);
    }

    public boolean isContains(Number number) {
        return numbers.contains(number);
    }

    public Rank getRank(WinningLotto winningLotto) {
        int count = (int) this.numbers.stream()
                .filter(number -> winningLotto.getLotto().isContains(number))
                .count();
        boolean isBonusMatch = numbers.contains(winningLotto.getBonus());
        return Rank.fromCountAndIsBonusMatch(count, isBonusMatch);
    }

    public List<Integer> getNumberValues() {
        return numbers.stream().map(Number::getValue).sorted().collect(toList());
    }

    public List<Number> getNumber() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(getNumberValues());
    }

}
