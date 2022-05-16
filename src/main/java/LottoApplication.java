import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController gameController = new LottoController(new InputView(), new ResultView());
        gameController.startGame();
    }
}
