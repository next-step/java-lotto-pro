import java.util.List;

public class LottoApp {

	private final LottoStore store;
	private final OutputView outputView;
	private final InputView inputView;

	public LottoApp() {
		this.store = new LottoStore();
		this.outputView = new OutputView();
		this.inputView = new InputView(outputView);
	}

	public void run() {
		final List<Lotto> lottos = wrapBuyLottoAt(store);
		outputView.boughtLotto(lottos);
		outputView.space();

		final WinningLotto winningLotto = wrapMakeWinningLotto();
		outputView.space();

		final LottoWinningStatistics statistics = LottoWinningStatistics.of(winningLotto, lottos);
		outputView.lottoWinningStatistics(statistics);
	}

	private List<Lotto> wrapBuyLottoAt(LottoStore store) {
		List<Lotto> lotto;
		do {
			lotto = buyLottoAt(store);
		} while (null == lotto);
		return lotto;
	}

	private List<Lotto> buyLottoAt(LottoStore store) {
		try {
			return store.sell(inputView.payKRW());
		} catch (LottoStorePaymentException e) {
			outputView.error(e.getMessage());
			return null;
		}
	}

	private WinningLotto wrapMakeWinningLotto() {
		WinningLotto winningLotto;
		do {
			winningLotto = makeWinningLotto();
		} while (null == winningLotto);
		return winningLotto;
	}

	private WinningLotto makeWinningLotto() {
		try {
			return WinningLotto.from(inputView.winningLotto());
		} catch (IllegalArgumentException e) {
			outputView.error(e.getMessage());
			return null;
		}
	}
}
