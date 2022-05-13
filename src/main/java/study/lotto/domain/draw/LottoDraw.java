package study.lotto.domain.draw;

import java.util.List;
import java.util.Objects;
import study.lotto.domain.LottoNumbers;
import study.lotto.domain.Lottos;

public class LottoDraw {
    private final LottoNumbers winningNumber;

    public LottoDraw(List<Integer> lottoNubmers) {
        this(new LottoNumbers(lottoNubmers));
    }

    public LottoDraw(LottoNumbers lottoNumbers) {
        winningNumber = lottoNumbers;
    }

    public DrawResult match(Lottos lottos) {
        DivisionResults divisionResults = lottos.findWinnings(winningNumber);
        return new DrawResult(divisionResults);
    }

    @Override
    public String toString() {
        return "LottoDraw{" +
                "winningNumber=" + winningNumber +
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
        return Objects.equals(winningNumber, lottoDraw.winningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber);
    }
}
