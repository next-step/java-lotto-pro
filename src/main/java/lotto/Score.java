package lotto;

import java.util.Objects;

public class Score {

    private final double score;

    private Score(double score) {
        this.score = score;
    }

    public double getScore() {
        return this.score;
    }

    public static Score of(double score) {
        return new Score(score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score1 = (Score) o;
        return Double.compare(score1.score, score) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    public boolean isBetween(double start, double end) {
        return start <= score && score < end;
    }
}
