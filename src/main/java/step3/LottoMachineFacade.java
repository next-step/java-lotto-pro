package step3;

import step3.machine.AutoLottoMachine;
import step3.machine.Machine;
import step3.machine.MachineValidation;
import step3.view.InputView;
import step3.view.ResultView;

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

	public void pick() {
		int insertMoney = inputView.insertMoney();
		money = new Money(insertMoney);
		Machine machine = new AutoLottoMachine(money, machineValidation);
		lottoPapers = machine.createLottoPapers();
		resultView.purchasedCount(money.findPunchCount());
		resultView.purchasedLottoPrint(lottoPapers);
	}

	public void result() {
		;
		Winner winner = new Winner(lottoPapers);
		winner.statistics(lottoNumberService.convertLottoNumber(inputView.insertLottoNumber()));
		winner.yield(money);
		resultView.statisticsPrintAndYield(winner);
	}

}
