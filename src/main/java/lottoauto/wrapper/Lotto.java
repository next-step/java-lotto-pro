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

    public Lotto(List<Integer> numbers) {
        checkEmpty(numbers);
        checkLength(numbers);

        insertIntegerList(numbers);
    }

    public Lotto(List<Integer> numbers, Number bonusNumber) {
        checkEmpty(numbers);
        checkLength(numbers);

        insertIntegerList(numbers);
        this.bonusNumber = bonusNumber;
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
        insertIntegerList(randomNumberExtractor.getRandomNumbers());
        this.bonusNumber = new Number(randomNumberExtractor.getBonusNumbers());
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

    public Integer getBonusNumber() {
        return bonusNumber.getNumber();
    }

    public int compare(List<Integer> compareLotto) {
        Collections.sort(compareLotto);
        List<Integer> tempLotto = insertNumberList(this.numbers);
        return (compareLotto.size() - tempLotto.stream().filter(win -> compareLotto.stream().noneMatch(Predicate.isEqual(win))).collect(Collectors.toList()).size());
    }

    public boolean compareBonus(Integer compareBonusNumber) {
        return this.bonusNumber.getNumber() == compareBonusNumber;
    }
}