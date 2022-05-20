package study.lotto;

import java.util.ArrayList;
import java.util.List;
import study.lotto.io.ConsoleInput;
import study.lotto.io.Printer;
import study.lotto.util.LottoGenerator;

public class LottoMain {
    private final Printer printer;

    public LottoMain(Printer printer) {
        validate(printer);
        this.printer = printer;
    }

    public void start() {
        List<Lotto> myLottos = buyLottos();
        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusNumber = getBonusNumber();
        printResult(myLottos, winningLotto, bonusNumber);
    }

    private void validate(Printer printer) {
        if (printer == null) {
            throw new IllegalArgumentException("printer가 없습니다.");
        }
    }

    private List<Lotto> buyLottos() {
        LottoMoney myLottoMoney = getLottoMoney();
        int manualBuyCount = getManualBuyCount(myLottoMoney);
        int autoBuyCount = getAutoBuyCount(myLottoMoney, manualBuyCount);
        return generateLottos(manualBuyCount, autoBuyCount);
    }

    private int getAutoBuyCount(LottoMoney myLottoMoney, int manualBuyCount) {
        return myLottoMoney.maxLottoTicketCount() - manualBuyCount;
    }

    private int getManualBuyCount(LottoMoney myLottoMoney) {
        printer.print("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualBuyCount = Integer.parseInt(ConsoleInput.read());
        if (!myLottoMoney.canBuyLottos(manualBuyCount)) {
            throw new IllegalArgumentException("구매 가능한 개수를 초과했습니다.");
        }
        return manualBuyCount;
    }

    private List<Lotto> generateLottos(int manualBuyCount, int autoBuyCount) {
        printer.print("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(LottoGenerator.generateManual(manualBuyCount));
        lottos.addAll(LottoGenerator.generate(autoBuyCount));
        printer.printMyLottos(lottos);
        return lottos;
    }

    private LottoMoney getLottoMoney() {
        printer.print("구매 금액을 입력해 주세요.");
        return new LottoMoney(Integer.parseInt(ConsoleInput.read()));
    }

    private Lotto getWinningLotto() {
        printer.print("지난 주 당첨 번호를 입력해 주세요.");
        return LottoGenerator.newManualLotto();
    }

    private LottoNumber getBonusNumber() {
        printer.print("보너스 볼을 입력해 주세요.");
        return new LottoNumber(Integer.parseInt(ConsoleInput.read()));
    }

    private void printResult(List<Lotto> lottos, Lotto lotto, LottoNumber bonusNumber) {
        LottoReport lottoReport = new LottoReport(lottos, new WinningLotto(lotto, bonusNumber));
        LottoResultMap lottoResultMap = lottoReport.analyze();
        printer.printResult(lottoResultMap);
    }
}
