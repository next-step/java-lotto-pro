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
        // 자동으로 발급된 로또 번호 저장
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

        if (manualTicketCount > 0) {
            lottos = InputView.inputManualLottos(manualTicketCount, lottos);
        }

        LottoMachine lottoMachine = new AutoLottoMachine();
        lottoMachine.purchaseLotto(lottoTicketCount - manualTicketCount, lottos);

        OutputView.outputCountLottoTicket(lottoTicketCount, manualTicketCount);
        // 지난주 당첨번호 입력
        OutputView.outputPurchaseLottoList(lottos);

        return lottos;
    }

}
