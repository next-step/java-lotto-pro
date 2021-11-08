package lotto2;

import java.util.List;

import lotto2.domain.LottoNumber;
import lotto2.domain.LottoStatics;
import lotto2.domain.LottoTicket;
import lotto2.domain.LottoTicketGenerator;
import lotto2.domain.LottoTickets;
import lotto2.domain.Money;
import lotto2.domain.PositiveNumber;
import lotto2.domain.Purchase;
import lotto2.domain.WinningLotto;
import lotto2.view.InputView;
import lotto2.view.ResultView;

public class LottoGameController {

	// TODO: view 와 DTO 교환
	public static void main(String[] args) {

		Money money = Money.of(InputView.getMoney());
		int manualLottoCount = InputView.getManualLottoCount();
		List<List<Integer>> manualLottoNumbers = InputView.getManualLotto(manualLottoCount);
		LottoTickets tickets = LottoTickets.of(manualLottoNumbers);
		PositiveNumber autoLottoCount = Purchase.calculateCount(money);
		LottoTickets autoTickets = LottoTicketGenerator.generateByCount(autoLottoCount);
		tickets.addAll(autoTickets);
		ResultView.showLottoNumbers(autoLottoCount.toInt(), tickets);
		List<Integer> winningNumbers = InputView.getWinningLottoNumbers();
		int bonusNumber = InputView.getBonusNumber();
		WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(winningNumbers), LottoNumber.of(bonusNumber));
		LottoStatics lottoStatics = LottoStatics.of(tickets, winningLotto, money);
		ResultView.showPrize(lottoStatics);
	}

}
