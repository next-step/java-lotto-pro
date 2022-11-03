package lotto;

import java.util.Objects;

public class LottoBall {
    private final Number lottoNumber;
    private final Score score;

    public LottoBall(String lottoNumber, Score score) {
        this.lottoNumber = new LottoNumber(lottoNumber);
        this.score = score;
    }

    public int getIntNumber() {
        return lottoNumber.getIntNumber();
    }

    public double getScore() {
        return score.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoBall lottoBall = (LottoBall) o;
        return Objects.equals(lottoNumber, lottoBall.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
