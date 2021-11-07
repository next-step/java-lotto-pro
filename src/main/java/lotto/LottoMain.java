package lotto;

public class LottoMain {
	public static void main(String[] args) {
		Lottos lottos = InputView.purchaseLottos();
		Lotto winLotto = InputView.getWinLotto();
		LottoGame game = new LottoGame(winLotto);
		ResultView.printResult(game.winPrize(lottos));
	}
}
