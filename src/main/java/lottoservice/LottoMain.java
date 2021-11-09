package lottoservice;

import lottoservice.exception.DuplicateBonusNumberAndWinningNumbers;
import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.exception.InvalidMoneyException;
import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.lottoticket.LottoTicketIssuer;
import lottoservice.lottoticket.LottoTickets;
import lottoservice.matcher.BonusNumber;
import lottoservice.matcher.LottoMatchResult;
import lottoservice.matcher.LottoPrizeAnswer;
import lottoservice.matcher.WinningNumbers;
import lottoservice.ui.ConsoleInputView;
import lottoservice.ui.ConsoleResultView;
import lottoservice.ui.InputView;
import lottoservice.ui.ResultView;

public class LottoMain {

	private static String GUIDE_MESSAGE_ENTER_INPUT_AMOUNT = "구매금액을 입력해주세요.";
	private static String GUIDE_MESSAGE_ENTER_LAST_WEEK_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해주세요.";
	private static String GUIDE_MESSAGE_ENTER_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
	private static String GUIDE_MESSAGE_MATCH_PROFIT_STATEMENT = "수동으로 구매할 로또 수를 입력해 주세요.";
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
		LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());
		LottoTicketIssuer lottoTicketIssuer = new LottoTicketIssuer(lottoNumbersMaker);
		LottoTickets lottoTickets = buyLottoTickets(lottoTicketIssuer);
		outputBoughtLottoTickets(lottoTickets);

		LottoPrizeAnswer lottoPrizeAnswer = getLottoPrizeAnswer(lottoNumbersMaker);
		LottoMatchResult lottoMatchResult = lottoPrizeAnswer.matchTickets(lottoTickets);
		outputLottoMatchResults(lottoMatchResult);
	}

	private LottoPrizeAnswer getLottoPrizeAnswer(LottoNumbersMaker lottoNumbersMaker) {
		try {
			WinningNumbers winningNumbers = getLastWeekWinningNumbers(lottoNumbersMaker);
			BonusNumber bonusNumber = getBonusNumber();
			return new LottoPrizeAnswer(winningNumbers, bonusNumber);
		}catch (DuplicateBonusNumberAndWinningNumbers ex){
			resultView.outputError(ex.getMessage());
			return getLottoPrizeAnswer(lottoNumbersMaker);
		}
	}

	private LottoTickets buyLottoTickets(LottoTicketIssuer lottoTicketIssuer) {
		try {
			String inputAmount = inputAmountForBuyLotto();
			return lottoTicketIssuer.buyAutoTickets(inputAmount);
		} catch (InvalidMoneyException ex) {
			resultView.outputError(ex.getMessage());
			return buyLottoTickets(lottoTicketIssuer);    /* 사용자가 잘못된 입력을 했을 경우 재입력 */
		}
	}

	private String inputAmountForBuyLotto() {
		resultView.outputGuide(GUIDE_MESSAGE_ENTER_INPUT_AMOUNT);
		return inputView.readInputLine();
	}

	private void outputBoughtLottoTickets(LottoTickets lottoTickets) {
		resultView.outputResult(lottoTickets);
	}

	private WinningNumbers getLastWeekWinningNumbers(LottoNumbersMaker lottoNumbersMaker) {
		try {
			String lastWeekWinningNumbers = inputLastWeekWinningNumbers();
			return new WinningNumbers(lottoNumbersMaker.makeLottoNumbers(lastWeekWinningNumbers));
		} catch (InvalidLottoFormatException ex) {
			resultView.outputError(ex.getMessage());
			return getLastWeekWinningNumbers(lottoNumbersMaker);    /* 사용자가 잘못된 입력을 했을 경우 재입력*/
		}
	}

	private BonusNumber getBonusNumber() {
		try {
			String number = inputBonusNumber();
			return new BonusNumber(number);
		} catch (InvalidLottoFormatException ex) {
			resultView.outputError(ex.getMessage());
			return getBonusNumber();    /* 사용자가 잘못된 입력을 했을 경우 재입력*/
		}
	}

	private String inputBonusNumber() {
		resultView.outputGuide(GUIDE_MESSAGE_ENTER_BONUS_NUMBER);
		return inputView.readInputLine();
	}

	private String inputLastWeekWinningNumbers() {
		resultView.outputGuide(GUIDE_MESSAGE_ENTER_LAST_WEEK_WINNING_NUMBERS);
		return inputView.readInputLine();
	}

	private void outputLottoMatchResults(LottoMatchResult matchResult) {
		resultView.outputGuide(RESULT_MESSAGE_MATCH_STATISTICS_START_LINE);
		resultView.outputResult(matchResult);
		resultView.outputResult(String.format(RESULT_MESSAGE_MATCH_PROFIT_STATEMENT,
			matchResult.calculateProfitPercentage()));
	}
}
