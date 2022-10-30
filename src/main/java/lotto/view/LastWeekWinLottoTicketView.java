package lotto.view;

import lotto.controller.LottoController;
import lotto.controller.dto.WinningLottoTicketResponse;
import utils.InputHandler;

public class LastWeekWinLottoTicketView {

	private static final String INPUT_PROMPT_OUTPUT = "지난 주 당첨 번호를 입력해 주세요.";
	private final LottoController lottoController;

	public LastWeekWinLottoTicketView(LottoController lottoController) {
		this.lottoController = lottoController;
	}

	public WinningLottoTicketResponse getLastWeekWinLotto() {
		System.out.println(INPUT_PROMPT_OUTPUT);
		WinningLottoTicketResponse lastWeekWinLottoTicket = lottoController.getWinningLottoTicket(InputHandler.input());

		System.out.println(lastWeekWinLottoTicket);
		System.out.println();

		return lastWeekWinLottoTicket;
	}

}
