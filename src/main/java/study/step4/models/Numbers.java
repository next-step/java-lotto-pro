package study.step4.models;

import study.step4.exception.LottoConsistOfSameNumbersException;
import study.step4.helper.NumbersParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static study.step3.constants.CommonConstants.SUB_LIST_END_INDEX;
import static study.step3.constants.CommonConstants.SUB_LIST_START_INDEX;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateLottoConsistOfDifferentNumbers(numbers);
        this.numbers = numbers;
    }

    public Numbers(String winLottoNumbers) {
        this.numbers = NumbersParser.stringToListInteger(winLottoNumbers);
    }

    private void validateLottoConsistOfDifferentNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        int expectedLottoNumberListSize = SUB_LIST_END_INDEX - SUB_LIST_START_INDEX;
        if (numberSet.size() != expectedLottoNumberListSize) {
            throw new LottoConsistOfSameNumbersException(String.format("로또는 서로 다른 %d 숫자로 이루어져야 합니다.", expectedLottoNumberListSize));
        }
    }

    public int countNumberOfMatching(Numbers winLottoNumbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += winLottoNumbers.containsNumber(number);
        }
        return result;
    }

    private int containsNumber(Integer number) {
        return numbers.contains(number) ? 1 : 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
