package study.lotto.domain.draw;

import java.util.List;
import java.util.Objects;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.LottoNumbers;
import study.lotto.domain.Lottos;

public class LottoDraw {
    private final LottoNumbers winningNumber;
    private final LottoNumber bonusNumber;

    public LottoDraw(List<Integer> lottoNubmers, int bonusNumber) {
        this.winningNumber = new LottoNumbers(lottoNubmers);
        this.bonusNumber = new LottoNumber(validateBonusDuplicates(winningNumber, bonusNumber));
    }

    public DrawResult match(Lottos lottos) {
        DivisionResults divisionResults = lottos.findWinnings(winningNumber);
        return new DrawResult(divisionResults);
    }

    private int validateBonusDuplicates(final LottoNumbers winningNumber, final int bonusNumber) {
        if (winningNumber.has(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "LottoDraw{" +
                "winningNumber=" + winningNumber +
                ", bonusNumber=" + bonusNumber +
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
        return Objects.equals(winningNumber, lottoDraw.winningNumber) && Objects.equals(bonusNumber,
                lottoDraw.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber, bonusNumber);
    }
}
