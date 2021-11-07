import lotto.*;

public class LottoController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoGenerator lottoGenerator = new LottoGenerator();
    public void start() {
        Money money = getMoney();

        Lottos lottos = lottoGenerator.createLottos(money.getLottoCount());
        outputView.printLottoCount(money.getLottoCount());
        outputView.printLottos(lottos);

        WinningNumber winningNumber = getWinningNumber();

        LottoResult lottoResult = new LottoResult(lottos.getLottos(), winningNumber);
        OutputView.printLottoResult(lottoResult);
    }

    private WinningNumber getWinningNumber() {
        try {
            return lottoGenerator.createWinningNumber(inputView.inputWiningLotto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private Money getMoney() {
        try {
            return new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }
}
