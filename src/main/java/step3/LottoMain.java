package step3;

public class LottoMain {

    public static void main(String[] args) {
        final LottoGame lottoGame = new LottoGame(new LottoResult());
        lottoGame.start();
    }
}
