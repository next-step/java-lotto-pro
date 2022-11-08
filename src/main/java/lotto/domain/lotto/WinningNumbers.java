package lotto.domain.lotto;

import static lotto.utils.Validations.requireNotNull;

import java.util.Objects;

public class WinningNumbers {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonus;

    public WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonus) {
        requireNotNull(winningNumbers, "당첨 번호는 null이 아니어야 합니다.");
        requireNotNull(bonus, "보너스는 null이 아니어야 합니다.");

        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public Matches match(final Lotto lotto) {
        return lotto.match(this.winningNumbers, this.bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return winningNumbers.equals(that.winningNumbers) && bonus.equals(that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonus);
    }
}
