package lotto.controller;

import java.util.List;

import lotto.controller.dto.BoughtLottoTicketsResponse;
import lotto.controller.dto.LottoWinResultsResponse;

public interface LottoController {
	BoughtLottoTicketsResponse buyLottoTickets(int buyingLottoTicketsAmount, List<List<Integer>> manualLottoTickets);

	LottoWinResultsResponse getWinResults(BoughtLottoTicketsResponse boughtLottoTickets,
										  List<Integer> winningLottoTicketResponse, int inputBonusNumber);
}
