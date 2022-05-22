package lottoauto.wrapper;

import lottoauto.util.RandomNumberExtractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        checkEmpty(numbers);
        checkLength(numbers);

        insertIntegerList(numbers);
    }


    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != 7) {
            throw new ArrayIndexOutOfBoundsException("6개의 숫자+보너스 숫자가 필요합니다.");
        }
    }

    private void checkEmpty(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new NullPointerException("null일 수 없습니다.");
        }
    }

    public Lotto() {
        RandomNumberExtractor randomNumberExtractor = new RandomNumberExtractor();
        insertIntegerList(randomNumberExtractor.getRandomNumbers());
    }

    private void insertIntegerList(List<Integer> tempLottoList) {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < tempLottoList.size(); i++) {
            Integer integer = tempLottoList.get(i);
            Number tempNumber = new Number(integer);
            this.numbers.add(tempNumber);
        }
    }

    private List<Integer> insertNumberList(List<Number> tempLottoList) {
        List<Integer> tempIntegerList = new ArrayList<>();
        for (Number number : tempLottoList) {
            tempIntegerList.add(number.getNumber());
        }
        return tempIntegerList;
    }

    @Override
    public String toString() {
        return insertNumberList(numbers).toString();
    }

    public List<Integer> toList() {
        return insertNumberList(this.numbers);
    }

    public int compare(List<Integer> compareLotto) {
        Collections.sort(compareLotto);
        List<Integer> tempLotto = insertNumberList(this.numbers);
        return (compareLotto.size() - tempLotto.stream().filter(win -> compareLotto.stream().noneMatch(Predicate.isEqual(win))).collect(Collectors.toList()).size());
    }
}