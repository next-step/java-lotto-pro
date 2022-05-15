package camp.nextstep.edu.step3;

import java.util.List;

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
        final LottoMoney purchaseAmount = presenter.askPurchaseAmount();
        final LottoPaper lottoPaper = machine.issued(purchaseAmount);
        presenter.printLottoList(lottoPaper);
        List<LottoNumber> lastWeekWinningNumber = presenter.askLastWeekWinningNumber();
        final LottoResult winningResult = lottoPaper.checkAll(generator.manual(lastWeekWinningNumber), validBonusNumber(lastWeekWinningNumber));
        presenter.printResult(winningResult, winningResult.earningRate(purchaseAmount));
    }

    private LottoNumber validBonusNumber(List<LottoNumber> lastWeekWinningNumber) {
        LottoNumber bonusNumber = presenter.askLottoBonusNumber();
        if (lastWeekWinningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 기존 번호와 중복이 될수 없습니다.");
        }
        return bonusNumber;
    }
}
