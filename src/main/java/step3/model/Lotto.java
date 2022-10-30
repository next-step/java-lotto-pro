package step3.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int NUMBER_SIZE = 6;
    private static final String NUMBER_SIZE_MESSAGE = "번호는 6개만 허용합니다";
    private static final String DUPLICATE_NUMBER_MESSAGE = "중복없는 번호만 허용합니다";
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static int getNumberSize() {
        return NUMBER_SIZE;
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        Set<LottoNumber> distinctNumbers = new HashSet(numbers);
        if (distinctNumbers.size() != numbers.size()) throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        if (distinctNumbers.size() != NUMBER_SIZE) throw new IllegalArgumentException(NUMBER_SIZE_MESSAGE);
    }

    public Rank getRank(List<LottoNumber> winningNumbers) {
        validateNumbers(winningNumbers);
        int count = (int) numbers
                .stream()
                .filter(winningNumbers::contains)
                .count();
        return Rank.valueOf(count);
    }

}
