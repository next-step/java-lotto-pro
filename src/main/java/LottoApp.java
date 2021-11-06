import java.util.List;

public class LottoApp {

	private final LottoStore store;
	private final View view;

	public LottoApp() {
		this.store = new LottoStore();
		this.view = new View();
	}

	public void run() {
		final List<Lotto> lottos = tryBuyLottos();
		view.outBoughtLotto(lottos);
		view.space();

		final WinningLotto winningLotto = tryMakeWinningLotto();
		view.space();

		final LottoWinningStatistics statistics = LottoWinningStatistics.of(winningLotto, lottos);
		view.outLottoWinningStatistics(statistics);
	}

	private List<Lotto> tryBuyLottos() {
		List<Lotto> lotto;
		do {
			lotto = buyLottos(view.inPayKRW());
		} while (null == lotto);
		return lotto;
	}

	private List<Lotto> buyLottos(String pay) {
		try {
			return store.sell(pay);
		} catch (LottoStorePaymentException e) {
			view.error(e.getMessage());
			return null;
		}
	}

	private WinningLotto tryMakeWinningLotto() {
		WinningLotto winningLotto;
		do {
			final String lottoNumbers = view.inWinningLotto();
			final String bonus = view.inBonus();
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
