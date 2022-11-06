package lotto;

import java.util.Objects;

public class LottoBall {

    private static final Score WIN_SCORE = Score.of(1);
    private static final Score BONUS_SCORE = Score.of(0.5);
    private final Number lottoNumber;
    private final Score score;

    private LottoBall(String lottoNumber, Score score) {
        this.lottoNumber = new LottoNumber(lottoNumber);
        this.score = score;
    }

    public int getIntNumber() {
        return lottoNumber.getIntNumber();
    }

    public Number getLottoNumber() {
        return lottoNumber;
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

    public static LottoBall fromStringNormal(String number) {
        return new LottoBall(number, WIN_SCORE);
    }

    public static LottoBall fromStringBonus(String number) {
        return new LottoBall(number, BONUS_SCORE);
    }
}
