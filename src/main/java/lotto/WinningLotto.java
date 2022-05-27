package lotto;

import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class WinningLotto {

    private Lotto winningLotto;
    private LottoNumber bonusLottoNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        validate(winningLotto, bonusLottoNumber);
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        if (winningLotto.getNumbers().existLottoNumber(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 번호를 중복된 숫자를 입력할 수 없습니다");
        }
    }

    public int matchNumberCount(Lotto lotto) {
        return this.winningLotto.getNumbers().getValues().stream()
            .filter(lotto.getNumbers().getValues()::contains)
            .collect(Collectors.toList()).size();
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().existLottoNumber(bonusLottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusLottoNumber,
            that.bonusLottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusLottoNumber);
    }
}
