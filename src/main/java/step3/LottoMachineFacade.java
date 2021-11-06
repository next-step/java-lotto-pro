package step3;

public class LottoMachineFacade {

	public static LottoPapers PAPER;
	private Money money;
	private LottoNumberService lottoNumberService;

	public LottoMachineFacade(LottoNumberService lottoNumberService) {
		PAPER = LottoPapers.getInstance();
		this.lottoNumberService = lottoNumberService;
	}

	public LottoMachineFacade() {
		this(new LottoNumberService());
		PAPER = LottoPapers.getInstance();
	}

	public void pick(int insertMoney) {
		money = new Money(insertMoney);
		Machine machine = new Machine(money);
		machine.createLotto();
	}

	public void result(String userInputWinnerNumber) {
		Winner winner = new Winner();
		winner.statistics(lottoNumberService.convertLottoNumber(userInputWinnerNumber));
		winner.yield(money);
		ResultView.statisticsPrintAndYield(winner);
	}

}
