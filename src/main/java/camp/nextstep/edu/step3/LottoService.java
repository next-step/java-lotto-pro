package camp.nextstep.edu.step3;

public class LottoService {
    private final Presenter presenter;
    private final LottoVendingMachine machine;

    public LottoService(Presenter presenter) {
        this.presenter = presenter;
        this.machine = new LottoVendingMachine(new LottoGenerator());
    }

    public void task() {
        final int purchaseAmount = presenter.askPurchaseAmount();
        final LottoPaper lottoPaper = machine.issued(purchaseAmount);
        presenter.printLottoList(lottoPaper);
        final Total total = lottoPaper.checkAll(new Lotto(presenter.askLastWeekWinningNumber()));
        presenter.printResult(total, total.result(purchaseAmount));
    }
}
