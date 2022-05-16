package lottoauto.wrapper;

import lottoauto.util.InputNumberValidator;
import lottoauto.util.RandomNumberExtractor;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkEmpty(numbers);
        checkLength(numbers);
        checkNumberRange(numbers);

        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void checkNumberRange(List<Integer> numbers) {
        numbers.stream().filter(number -> number < 1 || number > 45).forEachOrdered(number -> {
            throw new NumberFormatException("1~45만 입력 가능합니다.");
        });
    }

    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new ArrayIndexOutOfBoundsException("6개의 숫자가 필요합니다.");
        }
    }

    private void checkEmpty(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new NullPointerException("null일 수 없습니다.");
        }
    }

    public Lotto() {
        RandomNumberExtractor randomNumberExtractor = new RandomNumberExtractor();
        this.numbers = randomNumberExtractor.getRandomNumbers();
        Collections.sort(this.numbers);
    }

    public Lotto(String input) {
        InputNumberValidator inputNumberValidator = new InputNumberValidator(input);
        this.numbers = inputNumberValidator.getNumbers();
        Collections.sort(this.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> toList() {
        return this.numbers;
    }

    public int compare(List<Integer> compareLotto) {
        Collections.sort(compareLotto);
        return (compareLotto.size() - numbers.stream().filter(win -> compareLotto.stream().noneMatch(Predicate.isEqual(win))).collect(Collectors.toList()).size());
    }
}
