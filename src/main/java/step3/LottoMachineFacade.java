package step3;

import step3.machine.AutoLottoMachine;
import step3.machine.AutoMachineValidation;
import step3.machine.Machine;
import step3.machine.MachineValidation;

public class LottoMachineFacade {

	private Money money;
	private LottoNumberService lottoNumberService;
	private MachineValidation machineValidation;
	private LottoPapers lottoPapers;

	public LottoMachineFacade(LottoNumberService lottoNumberService, MachineValidation machineValidation) {
		this.lottoNumberService = lottoNumberService;
		this.machineValidation = machineValidation;
	}

	public LottoMachineFacade() {
		this(new LottoNumberService(), new AutoMachineValidation());
	}

	public void pick(int insertMoney) {
		money = new Money(insertMoney);
		Machine machine = new AutoLottoMachine(money, machineValidation);
		lottoPapers = machine.createLottoPapers();
		ResultView.purchasedLottoPrint(lottoPapers);
	}

	public void result(String userInputWinnerNumber) {
		Winner winner = new Winner(lottoPapers);
		winner.statistics(lottoNumberService.convertLottoNumber(userInputWinnerNumber));
		winner.yield(money);
		ResultView.statisticsPrintAndYield(winner);
	}

}
