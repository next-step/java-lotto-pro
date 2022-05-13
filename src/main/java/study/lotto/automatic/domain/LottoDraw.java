package study.lotto.automatic.domain;

import java.util.Objects;
import study.lotto.automatic.domain.draw.Division;

public class LottoDraw {
    private final LottoNumbers winningNumber;

    public LottoDraw(LottoNumbers lottoNumbers) {
        winningNumber = lottoNumbers;
    }

    public LottoDraw(LottoGenerator lottoGenerator) {
        winningNumber = lottoGenerator.generate();
    }

    public Division match(Lotto lotto) {
        return Division.valueOfMatchCount(lotto.match(winningNumber));
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
