package study.step3;

import study.step3.exception.LottoConsistOfSameNumbersException;
import study.step3.exception.LottoNumberListSizeException;

import java.util.*;

public class Lotto {
    private static final int SUB_LIST_START_INDEX = 0;
    private static final int SUB_LIST_END_INDEX = 6;

    private List<Integer> numbers;

    public Lotto() {
        numbers = makeLotto();
        validateLottoNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateLottoNumbers();
    }

    private void validateLottoNumbers() {
        validateLottoNumberListSize();
        validateLottoConsistOfDifferentNumbers();
    }

    private void validateLottoConsistOfDifferentNumbers() {
        Set<Integer> numberSet = new HashSet<>(numbers);
        int expectedLottoNumberListSize = SUB_LIST_END_INDEX - SUB_LIST_START_INDEX;
        if (numberSet.size() != expectedLottoNumberListSize) {
            throw new LottoConsistOfSameNumbersException("로또는 서로 다른 숫자로 이루어져야 합니다.");
        }
    }

    private void validateLottoNumberListSize() {
        int expectedLottoNumberListSize = SUB_LIST_END_INDEX - SUB_LIST_START_INDEX;
        if (numbers.size() != expectedLottoNumberListSize) {
            throw new LottoNumberListSizeException(String.format("로또는 %d개의 숫자로 이루어져야 합니다.", expectedLottoNumberListSize));
        }
    }

    private List<Integer> makeLotto() {
        numbers = new ArrayList<>(LottoNumberRange.shuffledNumbers()
                .subList(SUB_LIST_START_INDEX, SUB_LIST_END_INDEX));
        Collections.sort(numbers);
        return numbers;
    }

    private int containsNumber(Integer number) {
        return numbers.contains(number) ? 1 : 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int countMatchingNumbers(Lotto winLotto) {
        int result = 0;
        for (Integer number : numbers) {
            result += winLotto.containsNumber(number);
        }
        return result;
    }
}
