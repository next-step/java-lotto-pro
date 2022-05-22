package study.lotto.domain.draw;

import java.util.Objects;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.Lottos;

public class LottoDraw {
    private final LottoNumber bonusNumber;
    private final Lotto winningLotto;

    public LottoDraw(Lotto winningLotto, LottoNumber bonusNumber) {
        this.bonusNumber = validateBonusDuplicates(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
    }

    public DrawResult match(Lottos lottos) {
        return lottos.findWinnings(winningLotto, bonusNumber);
    }

    private LottoNumber validateBonusDuplicates(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.has(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "LottoDraw{" +
                "bonusNumber=" + bonusNumber +
                ", winningLotto=" + winningLotto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoDraw lottoDraw = (LottoDraw) o;
        return Objects.equals(bonusNumber, lottoDraw.bonusNumber) && Objects.equals(winningLotto,
                lottoDraw.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber, winningLotto);
    }
}
