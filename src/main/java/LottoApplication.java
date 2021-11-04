import controller.LottoGame;

public class LottoApplication {

	public static void main(String[] args) {
		LottoGame.instance()
			.play();
	}
}
