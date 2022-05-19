package study.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import study.lotto.util.StringUtil;

public class Lotto {
    private static final String NUMBER_DELIMITER = ",";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateAndSort();
    }

    public Lotto(String numbersString) {
        numbers = StringUtil.splitAndParseInt(numbersString, NUMBER_DELIMITER);
        validateAndSort();
    }

    public int numberSize() {
        return numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateAndSort() {
        validateSize(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 여섯개만 입력해야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("입력에 중복된 수가 있습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.getNumber());
    }
}
