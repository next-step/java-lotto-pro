package study.lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import study.lotto.io.Printer;
import study.lotto.util.LottoGenerator;

public class LottoMain {
    private static final String NUMBER_DELIMITER = ",";
    private final Printer printer;

    public LottoMain(Printer printer) {
        validate(printer);
        this.printer = printer;
    }

    private void validate(Printer printer) {
        if (printer == null) {
            throw new IllegalArgumentException("printer 가 없습니다.");
        }
    }

    public void start() {
        LottoMoney myLottoMoney = getLottoMoney();
        List<Lotto> myLottos = generateLottos(myLottoMoney);
        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusNumber = getBonusNumber();

        printResult(myLottos, winningLotto, bonusNumber);
    }

    private LottoMoney getLottoMoney() {
        printer.print("구매 금액을 입력해 주세요.");
        return new LottoMoney(Integer.parseInt(Console.readLine()));
    }

    private List<Lotto> generateLottos(LottoMoney lottoMoney) {
        List<Lotto> lottos = LottoGenerator.generate(lottoMoney.maxLottoTicketCount());
        printer.printMyLottos(lottos);
        return lottos;
    }

    private Lotto getWinningLotto() {
        printer.print("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(LottoGenerator.splitAndParseLottoNumber(
                Console.readLine(),
                NUMBER_DELIMITER
        ));
    }

    private LottoNumber getBonusNumber() {
        printer.print("보너스 볼을 입력해 주세요.");
        return new LottoNumber(Integer.parseInt(Console.readLine()));
    }

    private void printResult(List<Lotto> lottos, Lotto lotto, LottoNumber bonusNumber) {
        LottoReport lottoReport = new LottoReport(lottos, new WinningLotto(lotto, bonusNumber));
        LottoResultMap lottoResultMap = lottoReport.analyze();

        printer.printResult(lottoResultMap);
    }
}
