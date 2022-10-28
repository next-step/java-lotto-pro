package view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.LottoTicket;
import utils.SplitStrings;
import utils.StringSplitter;

public class LastWeekWinLottoTicketView {

	private static final String INPUT_PROMPT_OUTPUT = "지난 주 당첨 번호를 입력해 주세요.";

	private final Scanner scanner;

	public LastWeekWinLottoTicketView(Scanner scanner) {
		this.scanner = scanner;
	}

	public LottoTicket getLastWeekWinLotto() {
		System.out.println(INPUT_PROMPT_OUTPUT);

		String input = scanner.next();
		LottoTicket lastWeekWinLottoTicket = getLottoTicket(input);

		System.out.println(lastWeekWinLottoTicket);

		System.out.println();

		return lastWeekWinLottoTicket;
	}

	private static LottoTicket getLottoTicket(String input) {
		SplitStrings splitStrings = StringSplitter.split(input);

		List<Integer> lastWeekWinLottoNumbers = splitStrings.stream()
			.map(Integer::valueOf)
			.collect(Collectors.toList());

		return LottoTicket.of(lastWeekWinLottoNumbers);
	}
}
