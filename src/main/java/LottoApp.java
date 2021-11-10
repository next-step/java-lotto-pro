public class LottoApp {

	private final LottoStore lottoStore;
	private final View view;
	private final BuyLottosController buyLottosController;

	public LottoApp() {
		this.lottoStore = new LottoStore();
		this.view = new View();
		this.buyLottosController = new BuyLottosController(view);
	}

	public void run() {
		final Lottos lottos = buyLottosController.buyLottosAt(lottoStore);
		view.space();

		final WinningLotto winningLotto = tryMakeWinningLotto();
		view.space();

		final LottoWinningStatistics statistics = LottoWinningStatistics.from(winningLotto, lottos);
		view.outLottoWinningStatistics(statistics);
	}

	private WinningLotto tryMakeWinningLotto() {
		WinningLotto winningLotto;
		do {
			final String lottoNumbers = view.inWinningLotto();
			final String bonus = view.inWinningBonus();
			winningLotto = makeWinningLotto(lottoNumbers, bonus);
		} while (null == winningLotto);
		return winningLotto;
	}

	private WinningLotto makeWinningLotto(String lottoNumbers, String bonus) {
		try {
			return WinningLottoBuilder.aWinningLotto()
				.withLottoNumbers(lottoNumbers)
				.withBonus(bonus)
				.build();
		} catch (IllegalArgumentException e) {
			view.error(e.getMessage());
			return null;
		}
	}
}
