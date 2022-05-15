package study.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import study.step3.util.StringUtil;

public class Lotto {
    static final List<Integer> WHOLE_LOTTO_NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    private static final String NUMBER_DELIMITER = ",";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto() {
        numbers = shuffleAndSlice(new ArrayList<>(WHOLE_LOTTO_NUMBERS), 6);
        Collections.sort(numbers);
    }

    public Lotto(String numbersString) {
        numbers = StringUtil.splitAndParseInt(numbersString, NUMBER_DELIMITER);
        validate(numbers);
        Collections.sort(numbers);
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

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
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

    public static List<Integer> shuffleAndSlice(List<Integer> numbers, int count) {
        Collections.shuffle(numbers);
        return numbers.subList(0, count);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
