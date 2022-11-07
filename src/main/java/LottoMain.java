import domain.*;
import view.InputView;
import view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoMain lottoMain = new LottoMain();
        //입력받은 금액 설정
        Money money = new Money(InputView.inputReadPurchaseMoney());
        int lottoTicketCount = money.countOfLottoTicket();
        //입력받은 금액에 횟수 반환
        OutputView.outputCountLottoTicket(lottoTicketCount);
        // 자동으로 발급된 로또 번호 저장
        LottoMachine lottoMachine = new AutoLottoMachine();
        Lottos lottos = lottoMachine.purchaseLotto(lottoTicketCount);
        // 지난주 당첨번호 입력
        OutputView.outputPurchaseLottoList(lottos);

        // 당첨 비교
        WinLotto winLotto = new WinLotto(InputView.inputWinLottoNumbers(), new LottoNumber(InputView.inputBonusNumber()));
        WinReport winReport = new WinReport();

        winReport.findWinner(winLotto,lottos);
        OutputView.outputReportStart();
        // 결과 출력
        lottoMain.getResultPrintMessage(winReport, lottoTicketCount);
    }

    public void getResultPrintMessage(WinReport winReport, int lottoTicketCount) {
        OutputView.MatchReportResult(winReport);
        OutputView.outputProfit(winReport, lottoTicketCount);
    }

}
