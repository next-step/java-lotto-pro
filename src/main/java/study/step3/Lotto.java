package study.step3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import study.step3.util.StringUtil;

public class Lotto {
    static final List<Integer> WHOLE_LOTTO_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
            42, 43, 44, 45);
    private static final String NUMBER_DELIMITER = ",";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto() {
        numbers = StringUtil.shuffleAndSlice(WHOLE_LOTTO_NUMBERS, 6);
    }

    public Lotto(String numbersString) {
        numbers = validate(StringUtil.splitAndParseInt(numbersString, NUMBER_DELIMITER));
    }

    public int matchCount(Lotto winningLotto) {
        Set<Integer> lottoSet = new HashSet<>();
        lottoSet.addAll(winningLotto.getNumbers());
        lottoSet.addAll(this.getNumbers());
        return LOTTO_NUMBER_SIZE * 2 - lottoSet.size();
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 여섯개만 입력해야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!new HashSet<>(WHOLE_LOTTO_NUMBERS).containsAll(numbers)) {
            throw new IllegalArgumentException("로또는 1-45 범위 내에서 입력해야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("입력에 중복된 수가 있습니다.");
        }
    }
}
