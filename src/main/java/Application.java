import lotto.controller.LottoController;
import lotto.domain.LottoGame;

public class Application {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        LottoController lottoController = new LottoController(lottoGame);
        lottoController.startLotto();
    }
}
