package study.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
        validateAndSort();
    }

    public int numberSize() {
        return numbers.size();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validateAndSort() {
        validateSize(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 여섯개만 입력해야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("입력에 중복된 수가 있습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.stream()
                .anyMatch(number -> number.getNumber().equals(lottoNumber.getNumber()));
    }
}
