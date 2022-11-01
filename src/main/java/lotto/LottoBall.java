package lotto;

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
}
