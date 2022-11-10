package lotto.domain.lotto;

import static lotto.utils.Validations.requireNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(final List<Integer> numbers) {
        this(new LottoNumbers(numbers));
    }

    public Lotto(final LottoNumbers numbers) {
        requireNotNull(numbers, "숫자들은 null이 아니어야 합니다.");

        this.numbers = numbers;
    }

    public Matches match(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        requireNotNull(winningNumbers, "당첨 번호는 null이 아니어야 합니다.");
        requireNotNull(bonusNumber, "보너스 번호는 null이 아니어야 합니다.");

        return Matches.of(countMatchedNumber(winningNumbers), contains(bonusNumber));
    }

    public List<Integer> toInts() {
        return this.numbers.toInts();
    }

    private long countMatchedNumber(LottoNumbers winningNumbers) {
        return this.numbers.countMatchedNumber(winningNumbers);
    }

    private boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
