package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public final static int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateNumbers(numbers);

        this.numbers = new ArrayList<>();
        for (int number : numbers) {
            this.numbers.add(new LottoNumber(number));
        }

        Collections.sort(this.numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBERS_SIZE){
            throw new IllegalArgumentException("숫자의 개수는 6개여야 합니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
    }

    public int compareLottoNumbersAndReturnMatchCount(LottoNumbers winningLottoNumbers) {
        int count = 0;

        for (LottoNumber number : winningLottoNumbers.numbers) {
            count = count + compareNumberAndReturnAddCount(number);
        }

        return count;
    }

    private int compareNumberAndReturnAddCount(LottoNumber number) {
        if(compareNumber(number)) {
            return 1;
        }

        return 0;
    }

    private boolean compareNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }
}
