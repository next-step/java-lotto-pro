package lotto;

import lotto.controller.LottoController;
import lotto.domain.AutoLottoTicketGenerator;
import lotto.domain.AutoLottoTicketsVendor;
import lotto.view.input.LottoBonusNumberInputView;
import lotto.view.input.LottoManualNumbersInputView;
import lotto.view.input.LottoMoneyInputView;
import lotto.view.input.LottoWinNumberInputView;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoWinOutputView;
import money.Money;
import utils.InputHandler;

public class LottoFactory {

	private static final Money LOTTO_PRICE = Money.wons(1000);

	private static final InputHandler inputHandler = InputHandler.createSystemIn();

	public static LottoController createLottoController() {
		return new LottoController(
			LOTTO_PRICE,
			new AutoLottoTicketsVendor(new AutoLottoTicketGenerator()));
	}

	public static LottoMoneyInputView createMoneyInputView() {
		return new LottoMoneyInputView(inputHandler);
	}

	public static LottoManualNumbersInputView createManualNumbersInputView() {
		return new LottoManualNumbersInputView(inputHandler);
	}

	public static LottoBuyOutputView createBuyOutputView() {
		return new LottoBuyOutputView();
	}

	public static LottoWinNumberInputView createWinNumberInputView() {
		return new LottoWinNumberInputView(inputHandler);
	}

	public static LottoBonusNumberInputView createBonusNumberInputView() {
		return new LottoBonusNumberInputView(inputHandler);
	}

	public static LottoWinOutputView createWinOutputView() {
		return new LottoWinOutputView();
	}
}
