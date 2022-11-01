package lotto;

public class BonusScore implements Score{

    static final double BONUS_SCORE = 0.5;
    @Override
    public double getScore() {
        return BONUS_SCORE;
    }
}
