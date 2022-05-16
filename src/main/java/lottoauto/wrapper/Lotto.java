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
        if (numbers.isEmpty()) {
            throw new NullPointerException("null일 수 없습니다.");
        }

        if (numbers.size() != 6) {
            throw new ArrayIndexOutOfBoundsException("6개의 숫자가 필요합니다.");
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new NumberFormatException("1~45만 입력 가능합니다.");
            }
        }

        this.numbers = numbers;
        Collections.sort(this.numbers);
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
        return (compareLotto.size() - numbers.stream().filter(win -> compareLotto.stream().noneMatch(Predicate.isEqual(win)))
                .collect(Collectors.toList()).size());
    }
}
