package lotto.view;

import java.util.List;

import utils.InputHandler;

public class LastWeekWinLottoTicketView {

	private static final String INPUT_PROMPT_OUTPUT = "지난 주 당첨 번호를 입력해 주세요.";

	public LastWeekWinLottoTicketView() {
	}

	public List<Integer> getLastWeekWinLotto() {
		System.out.println(INPUT_PROMPT_OUTPUT);

		return InputHandler.inputIntegerList();
	}

}
