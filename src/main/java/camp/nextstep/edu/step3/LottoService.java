package camp.nextstep.edu.step3;

public class LottoService {
    private final Presenter presenter;
    private final LottoVendingMachine machine;
    private final LottoGenerator generator;

    public LottoService(Presenter presenter) {
        this.presenter = presenter;
        this.generator = new LottoGenerator();
        this.machine = new LottoVendingMachine(this.generator);
    }

    public void task() {
        final int purchaseAmount = presenter.askPurchaseAmount();
        final LottoPaper lottoPaper = machine.issued(purchaseAmount);
        presenter.printLottoList(lottoPaper);
        final Total total = lottoPaper.checkAll(generator.manual(presenter.askLastWeekWinningNumber()));
        presenter.printResult(total, total.result(purchaseAmount));
    }
}
