package lotto;

import lotto.controller.Controller;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		Controller controller = new Controller(inputView, resultView);
		controller.run();
	}
}
