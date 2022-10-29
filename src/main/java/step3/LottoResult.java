package step3;

public class LottoResult {

    private int score;
    private int scoreMatchedCount;
    private int money;

    public LottoResult(int score, int scoreMatchedCount, int money) {
        this.score = score;
        this.scoreMatchedCount = scoreMatchedCount;
        this.money = money;
    }

    public int getScore() {
        return score;
    }

    public int getScoreMatchedCount() {
        return scoreMatchedCount;
    }

    public int getMoney() {
        return money;
    }
}
