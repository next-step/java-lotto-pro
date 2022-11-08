import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class LottoMain {

    public static void main(String[] args) {
        LottoMain lottoMain = new LottoMain();

        //입력받은 금액, 횟수 설정
        int lottoTicketCount = lottoMain.getLottoTicketCount();
        //수동 구매 횟수 입력
        int manualLottoTicketCount = InputView.inputManualLottoCount();
        // 자동,수동 발급된 로또 번호 저장
        Lottos lottos = lottoMain.purchaseLotto(lottoTicketCount, manualLottoTicketCount);
        // 당첨 비교
        WinLotto winLotto = new WinLotto(InputView.inputWinLottoNumbers(), new LottoNumber(InputView.inputBonusNumber()));
        WinReport winReport = new WinReport();

        winReport.findWinner(winLotto, lottos);
        OutputView.outputReportStart();
        // 결과 출력
        lottoMain.getResultPrintMessage(winReport, lottoTicketCount);
    }

    public void getResultPrintMessage(WinReport winReport, int lottoTicketCount) {
        OutputView.MatchReportResult(winReport);
        OutputView.outputProfit(winReport, lottoTicketCount);
    }

    public int getLottoTicketCount() {
        Money money = new Money(InputView.inputReadPurchaseMoney());
        int lottoTicketCount = money.countOfLottoTicket();


        return lottoTicketCount;
    }

    public Lottos purchaseLotto(int lottoTicketCount, int manualTicketCount) {
        Lottos lottos = new Lottos(new ArrayList<>());
        // 수동 로또 구입
        if (manualTicketCount > 0) {
            InputView.inputManualLottosPrint();
            String[] manualLottoNumbers = InputView.inputManualLottos(manualTicketCount);
            LottoMachine lottoMachine = new ManualLottoMachine(manualLottoNumbers, lottos);
            lottoMachine.purchaseLotto();
        }
        // 자동 로또 구입
        LottoMachine lottoMachine = new AutoLottoMachine(lottoTicketCount - manualTicketCount, lottos);
        lottoMachine.purchaseLotto();

        OutputView.outputCountLottoTicket(lottoTicketCount, manualTicketCount);
        OutputView.outputPurchaseLottoList(lottos);

        return lottos;
    }

}
