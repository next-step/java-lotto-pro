package step3.machine;

import step3.LottoNumberService;
import step3.LottoPapers;
import step3.Money;
import step3.view.InputView;
import step3.view.ResultView;
import step3.winner.Winner;

public class LottoMachineFacade {

	private Money money;
	private LottoNumberService lottoNumberService;
	private MachineValidation machineValidation;
	private LottoPapers lottoPapers;
	private InputView inputView;
	private ResultView resultView;

	public LottoMachineFacade(LottoNumberService lottoNumberService, MachineValidation machineValidation, InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
		this.lottoNumberService = lottoNumberService;
		this.machineValidation = machineValidation;
	}

	public void start() {
		insertMoney();
		createLottoPapers();
		resultPrint();
	}

	private void insertMoney() {
		int insertMoney = inputView.insertMoney();
		money = new Money(insertMoney);
	}

	private void createLottoPapers() {
		Machine machine = new AutoLottoMachine(machineValidation);
		machine.insertMoney(money);
		lottoPapers = machine.createLottoPapers();
	}

	private void resultPrint() {
		resultView.purchasedCount(money.findPunchCount());
		resultView.purchasedLottoPrint(lottoPapers);
	}

	public void findWinner() {
		Winner winner = new Winner(lottoPapers);
		winner.statistics(lottoNumberService.convertLottoNumber(inputView.insertLottoNumber()));
		winner.yield(money);
		resultView.statisticsPrintAndYield(winner);
	}

}
