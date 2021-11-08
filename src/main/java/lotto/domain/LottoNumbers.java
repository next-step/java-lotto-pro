package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoNumbers {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_QUANTITY = 6;
    
    private final List<Integer> numbers;

    private LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers valueOf(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchNumber(LottoNumbers winningNumbers) {
        return (int) numbers.stream()
                        .filter(number -> winningNumbers.getNumbers()
                        .contains(number))
                        .count();
    }

    public boolean isMatchBonus(Bonus bonus) {
        return numbers.stream().anyMatch(number -> bonus.isMatchBonus(number));
    }

    @Override
    public String toString() {
        return Arrays.deepToString(numbers.toArray());
    }

}
