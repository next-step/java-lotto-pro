package study.lotto.automatic.domain;

import java.util.Objects;

public class LottoDraw {
    private final LottoNumbers winningNumber;

    public LottoDraw(LottoNumbers lottoNumbers) {
        winningNumber = lottoNumbers;
    }

    public LottoDraw(LottoGenerator lottoGenerator) {
        winningNumber = lottoGenerator.generate();
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
