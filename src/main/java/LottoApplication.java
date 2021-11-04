import controller.LottoGame;
import model.LottoRule;

public class LottoApplication {

	private static final int LOTTO_PRICE = 1_000;
	private static final LottoRule RULE = LottoRule.of(1, 45, 6);

	public static void main(String[] args) {
		LottoGame.from(LOTTO_PRICE, RULE)
			.play();
	}
}
