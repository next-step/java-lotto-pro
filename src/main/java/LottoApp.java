import java.util.List;

public class LottoApp {

	private final LottoBuyer buyer;
	private final View view;

	public LottoApp() {
		this.buyer = new LottoBuyer(new LottoStore());
		this.view = new View();
	}

	public void run() {
		final List<Lotto> lottos = buyer.buy();
		view.space();

		final WinningLotto winningLotto = tryMakeWinningLotto();
		view.space();

		final LottoWinningStatistics statistics = LottoWinningStatistics.of(winningLotto, lottos);
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
