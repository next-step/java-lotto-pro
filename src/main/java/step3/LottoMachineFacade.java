package step3;

public class LottoMachineFacade {

	public static LottoPapers PAPERS;
	private Money money;
	private LottoNumberService lottoNumberService;

	public LottoMachineFacade(LottoNumberService lottoNumberService) {
		PAPERS = LottoPapers.getInstance();
		this.lottoNumberService = lottoNumberService;
	}

	public LottoMachineFacade() {
		this(new LottoNumberService());
		PAPERS = LottoPapers.getInstance();
	}

	public void pick(int insertMoney) {
		money = new Money(insertMoney);
		Machine machine = new Machine(money);
		machine.createLotto();
		ResultView.purchasedCount(LottoPapers.PAPERS.size());
		ResultView.purchasedLottoPrint();
	}

	public void result(String userInputWinnerNumber) {
		Winner winner = new Winner();
		winner.statistics(lottoNumberService.convertLottoNumber(userInputWinnerNumber));
		winner.yield(money);
		ResultView.statisticsPrintAndYield(winner);
	}

}
