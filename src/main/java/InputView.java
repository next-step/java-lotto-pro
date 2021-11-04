import nextstep.utils.Console;

public class InputView {

	private final OutputView outputView;

	public InputView(OutputView outputView) {
		this.outputView = outputView;
	}

	public int payKRW() {
		outputView.payKRW();
		return Console.readInt();
	}

	public String winningLotto() {
		outputView.winningLotto();
		return Console.readLine();
	}
}
