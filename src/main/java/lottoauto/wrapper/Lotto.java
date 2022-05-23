package lottoauto.wrapper;

import lottoauto.util.RandomNumberExtractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private List<Number> numbers;
    private Number bonusNumber;

    private static final int MAX_USER_LOTTO_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        checkEmpty(numbers);
        checkLength(numbers);

        insertIntegerList(numbers);
    }

    public Lotto(List<Integer> numbers, Number bonusNumber) {
        checkEmpty(numbers);
        checkLength(numbers);

        this.bonusNumber = bonusNumber;
        insertIntegerList(numbers);
    }


    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != MAX_USER_LOTTO_COUNT) {
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
        insertIntegerList(randomNumberExtractor.getRandomNumbers());
    }

    private void insertIntegerList(List<Integer> tempLottoList) {
        this.numbers = new ArrayList<>();
        for (Integer integer : tempLottoList) {
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
        List<Integer> tempIntegerList = insertNumberList(numbers);
        return tempIntegerList.toString();
    }

    public List<Integer> toList() {
        return insertNumberList(this.numbers);
    }

    public Integer getBonusNumber() {
        return bonusNumber.getNumber();
    }

    public int compare(List<Integer> compareLotto) {
        Collections.sort(compareLotto);
        List<Integer> tempLotto = insertNumberList(this.numbers);
        Collections.sort(tempLotto);
        return (compareLotto.size() - tempLotto.stream().filter(win -> compareLotto.stream().noneMatch(Predicate.isEqual(win))).collect(Collectors.toList()).size());
    }

    public boolean compareBonus(List<Integer> compareLotto) {
        return compareLotto.contains(this.bonusNumber.getNumber());
    }
}