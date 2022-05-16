package study.lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import study.lotto.io.Printer;
import study.lotto.util.LottoGenerator;

public class LottoMain {
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
        printer.print("구매 금액을 입력해 주세요.");
        LottoMoney lottoMoney = new LottoMoney(Console.readLine());

        List<Lotto> lottos = LottoGenerator.generate(lottoMoney.maxLottoTicketCount());
        printer.printMyLottos(lottos);

        printer.print("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningLotto = new Lotto(Console.readLine());

        LottoReport lottoReport = new LottoReport(lottos, winningLotto);
        LottoResultMap lottoResultMap = lottoReport.analyze();

        printer.printResult(lottoResultMap);
    }
}
