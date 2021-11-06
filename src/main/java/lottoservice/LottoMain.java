package lottoservice;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.exception.InvalidMoneyException;
import lottoservice.lottoticket.LottoTicketIssuer;
import lottoservice.lottoticket.LottoTickets;
import lottoservice.matcher.LottoMatchResult;
import lottoservice.matcher.LottoMatcher;
import lottoservice.matcher.LottoWinningNumbers;
import lottoservice.ui.ConsoleInputView;
import lottoservice.ui.ConsoleResultView;
import lottoservice.ui.InputView;
import lottoservice.ui.ResultView;

public class LottoMain {

	private static String GUIDE_MESSAGE_ENTER_INPUT_AMOUNT = "구매금액을 입력해주세요.";
	private static String GUIDE_MESSAGE_ENTER_LAST_WEEK_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해주세요.";
	private static String RESULT_MESSAGE_MATCH_STATISTICS_START_LINE = "\n당첨통계\n---------";
	private static String RESULT_MESSAGE_MATCH_PROFIT_STATEMENT = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	private InputView inputView;
	private ResultView resultView;

	public LottoMain(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public static void main(String[] args) {
		InputView userInputView = new ConsoleInputView();
		ResultView resultView = new ConsoleResultView();
		LottoMain lottoMain = new LottoMain(userInputView, resultView);
		lottoMain.startLottoMain();
	}

	public void startLottoMain() {
		LottoTickets lottoTickets = buyLottoTickets();
		outputBoughtLottoTickets(lottoTickets);
		LottoWinningNumbers lottoWinningNumbers = getLastWeekWinningNumbers();
		LottoMatchResult lottoMatchResult = matchLottoWinning(lottoWinningNumbers, lottoTickets);
		outputLottoMatchResults(lottoMatchResult);
	}

	private LottoTickets buyLottoTickets() {
		try {
			String inputAmount = inputAmountForBuyLotto();
			return LottoTicketIssuer.buyTickets(inputAmount);
		} catch (InvalidMoneyException ex) {
			resultView.outputError(ex.getMessage());
			return buyLottoTickets();    /* 사용자가 잘못된 입력을 했을 경우 재입력 */
		}
	}

	private String inputAmountForBuyLotto() {
		resultView.outputGuide(GUIDE_MESSAGE_ENTER_INPUT_AMOUNT);
		return inputView.readInputLine();
	}

	private void outputBoughtLottoTickets(LottoTickets lottoTickets) {
		resultView.outputResult(lottoTickets);
	}

	private LottoWinningNumbers getLastWeekWinningNumbers() {
		try {
			String lastWeekWinningNumbers = inputLastWeekWinningNumbers();
			return LottoWinningNumbers.makeLottoWinningNumbers(lastWeekWinningNumbers);
		} catch (InvalidLottoFormatException ex) {
			resultView.outputError(ex.getMessage());
			return getLastWeekWinningNumbers();    /* 사용자가 잘못된 입력을 했을 경우 재입력*/
		}
	}

	private String inputLastWeekWinningNumbers() {
		resultView.outputGuide(GUIDE_MESSAGE_ENTER_LAST_WEEK_WINNING_NUMBERS);
		return inputView.readInputLine();
	}

	private LottoMatchResult matchLottoWinning(LottoWinningNumbers lottoWinningNumbers, LottoTickets lottoTickets) {
		LottoMatcher lottoMatcher = new LottoMatcher(lottoWinningNumbers);
		return lottoMatcher.matchWinningAndTickets(lottoTickets);
	}

	private void outputLottoMatchResults(LottoMatchResult matchResult) {
		resultView.outputGuide(RESULT_MESSAGE_MATCH_STATISTICS_START_LINE);
		resultView.outputResult(matchResult);
		resultView.outputResult(String.format(RESULT_MESSAGE_MATCH_PROFIT_STATEMENT,
			matchResult.calculateProfitPercentage()));
	}
}
