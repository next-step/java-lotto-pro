package lottoservice;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.exception.InvalidMoneyException;
import lottoservice.lottoticket.LottoTicketIssuer;
import lottoservice.lottoticket.LottoTickets;
import lottoservice.matcher.LottoMatchResult;
import lottoservice.matcher.LottoMatcher;
import lottoservice.matcher.LottoWinningNumbers;
import lottoservice.ui.InputView;
import lottoservice.ui.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		LottoMain lottoMain = new LottoMain();
		lottoMain.startLottoMain();
	}

	public void startLottoMain(){
		LottoTickets lottoTickets = buyLottoTickets();
		showTickets(lottoTickets);
		ResultView.pringNewLine();
		LottoWinningNumbers lottoWinningNumbers = getLastWeekWinningNumbers();
		ResultView.pringNewLine();
		showMatchLottoWinningResult(lottoWinningNumbers,lottoTickets);
	}

	private void showTickets(LottoTickets lottoTickets) {
		ResultView.printResultMessage(lottoTickets);
	}

	private String inputAmountForBuyLotto() {
		ResultView.printGuideMessage("구매금액을 입력해주세요.");
		return InputView.readLine();
	}

	private LottoTickets buyLottoTickets() {
		try {
			String inputAmount = inputAmountForBuyLotto();
			return LottoTicketIssuer.buyTickets(inputAmount);
		}catch (InvalidMoneyException ex){
			ResultView.printErrorMessage(ex.getMessage());
			return buyLottoTickets();
		}
	}

	private LottoWinningNumbers getLastWeekWinningNumbers() {
		try {
			String lastWeekWinningNumbers = inputLastWeekWinningNumbers();
			return LottoWinningNumbers.makeLottoWinningNumbers(lastWeekWinningNumbers);
		}catch (InvalidLottoFormatException ex){
			ResultView.printErrorMessage(ex.getMessage());
			return getLastWeekWinningNumbers();
		}
	}

	private String inputLastWeekWinningNumbers(){
			ResultView.printGuideMessage("지난 주 당첨 번호를 입력해주세요.");
			return InputView.readLine();
	}

	private void showMatchLottoWinningResult(LottoWinningNumbers lottoWinningNumbers, LottoTickets lottoTickets) {
		ResultView.printResultMessage("당첨통계\n---------\n");
		LottoMatcher lottoMatcher = new LottoMatcher(lottoWinningNumbers);
		LottoMatchResult matchResult = lottoMatcher.matchWinningAndTickets(lottoTickets);
		ResultView.printResultMessage(matchResult);
		ResultView.printResultMessage("총 수익률은 "+matchResult.calculateProfitPercentage()+"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미)");
	}
}
