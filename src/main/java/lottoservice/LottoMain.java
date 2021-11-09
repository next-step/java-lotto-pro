package lottoservice;

import java.util.ArrayList;
import java.util.List;

import lottoservice.exception.DuplicateBonusNumberAndWinningNumbers;
import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.exception.InvalidMoneyException;
import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.lottoticket.LottoTicket;
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

	private static final String GUIDE_MESSAGE_ENTER_INPUT_AMOUNT = "구매금액을 입력해주세요.";
	private static final String GUIDE_MESSAGE_ENTER_LAST_WEEK_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해주세요.";
	private static final String GUIDE_MESSAGE_ENTER_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
	private static final String GUIDE_MESSAGE_INPUT_NUM_OF_MANUAL_LOTTOES = "\n수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String GUIDE_MESSAGE_INPUT_LOTTO_NUMBERS_TO_MAKE_TICKET = "\n수동으로 구매할 번호를 입력해 주세요.";
	private static final String RESULT_MESSAGE_MATCH_STATISTICS_START_LINE = "\n당첨통계\n---------";
	private static final String RESULT_MESSAGE_MATCH_PROFIT_STATEMENT = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	private static final String RESULT_MESSAGE_TOTAL_NUM_OF_TICKETS = "\n수동으로 %s장 자동으로 %s장을 구매했습니다.";
	private static final String ERROR_MESSAGE_INVALID_INPUT_NUM_OF_MANUAL_LOTTOES = "구매할 로또 수를 0 이상의 정수로 입력해주세요.";

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
		LottoTickets autoLottoTickets = buyAutoLottoTickets(lottoTicketIssuer);
		LottoTickets manualLottoTickets = buyManualLottoTickets(lottoTicketIssuer);

		outputNumOfTotalBought(manualLottoTickets.getNumOfTickets(),autoLottoTickets.getNumOfTickets());
		outputBoughtLottoTickets(manualLottoTickets);
		outputBoughtLottoTickets(autoLottoTickets);

		LottoPrizeAnswer lottoPrizeAnswer = getLottoPrizeAnswer(lottoNumbersMaker);
		LottoMatchResult autoLottoMatchResult = lottoPrizeAnswer.matchTickets(autoLottoTickets, manualLottoTickets);
		outputLottoMatchResults(autoLottoMatchResult);
	}

	private LottoTickets buyManualLottoTickets(LottoTicketIssuer lottoTicketIssuer) {

		int sizeOfTickets = getNumOfTicketsToBuy();
		resultView.outputResult(GUIDE_MESSAGE_INPUT_LOTTO_NUMBERS_TO_MAKE_TICKET);
		List<LottoTicket> lottoTickets = new ArrayList<>();
		for (int i = 0; i < sizeOfTickets; i++) {
			lottoTickets.add(issuLottoTicket(lottoTicketIssuer));
		}
		return new LottoTickets(lottoTickets);
	}

	private LottoTicket issuLottoTicket(LottoTicketIssuer lottoTicketIssuer) {
		try {
			String numbers = inputLottoNumbers();
			return lottoTicketIssuer.buyManualTicket(numbers);
		} catch (NumberFormatException | InvalidLottoFormatException ex) {
			resultView.outputError(ex.getMessage());
			return issuLottoTicket(lottoTicketIssuer);
		}
	}

	private int getNumOfTicketsToBuy() {
		resultView.outputResult(GUIDE_MESSAGE_INPUT_NUM_OF_MANUAL_LOTTOES);
		try {
			String numOfTicket = inputView.readInputLine();
			validateInputNumOfTicket(numOfTicket);
			return Integer.parseInt(numOfTicket);
		} catch (IllegalArgumentException ex) {
			resultView.outputError(ERROR_MESSAGE_INVALID_INPUT_NUM_OF_MANUAL_LOTTOES);
			return getNumOfTicketsToBuy();    /* 사용자가 잘못된 입력을 했을 경우 재입력*/
		}
	}

	private void validateInputNumOfTicket(String numOfTicket) {
		int number = Integer.parseInt(numOfTicket);
		if(number<0) {
			throw new IllegalArgumentException();
		}
	}

	private LottoTickets buyAutoLottoTickets(LottoTicketIssuer lottoTicketIssuer) {
		try {
			String inputAmount = inputAmountForBuyLotto();
			return lottoTicketIssuer.buyAutoTickets(inputAmount);
		} catch (InvalidMoneyException ex) {
			resultView.outputError(ex.getMessage());
			return buyAutoLottoTickets(lottoTicketIssuer);    /* 사용자가 잘못된 입력을 했을 경우 재입력 */
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
		resultView.outputGuide(GUIDE_MESSAGE_ENTER_LAST_WEEK_WINNING_NUMBERS);
		String lastWeekWinningNumbers = inputLottoNumbers();
		try {
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

	private String inputLottoNumbers() {
		return inputView.readInputLine();
	}

	private void outputNumOfTotalBought(int numOfAutoTickets, int numOfManualTickets) {
		resultView.outputResult(String.format(RESULT_MESSAGE_TOTAL_NUM_OF_TICKETS, numOfAutoTickets,
			numOfManualTickets));
	}

	private LottoPrizeAnswer getLottoPrizeAnswer(LottoNumbersMaker lottoNumbersMaker) {
		try {
			WinningNumbers winningNumbers = getLastWeekWinningNumbers(lottoNumbersMaker);
			BonusNumber bonusNumber = getBonusNumber();
			return new LottoPrizeAnswer(winningNumbers, bonusNumber);
		} catch (DuplicateBonusNumberAndWinningNumbers ex) {
			resultView.outputError(ex.getMessage());
			return getLottoPrizeAnswer(lottoNumbersMaker);
		}
	}

	private void outputLottoMatchResults(LottoMatchResult matchResult) {
		resultView.outputGuide(RESULT_MESSAGE_MATCH_STATISTICS_START_LINE);
		resultView.outputResult(matchResult);
		resultView.outputResult(String.format(RESULT_MESSAGE_MATCH_PROFIT_STATEMENT,
			matchResult.calculateProfitPercentage()));
	}
}
