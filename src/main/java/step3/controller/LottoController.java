package step3.controller;

import step3.domain.LottoService;
import step3.dto.LottoTicketVouchersDto;
import step3.infra.LottoServiceImpl;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {
    LottoService lottoService;
    InputView inputView;
    ResultView resultView;

    public LottoController() {
        lottoService = new LottoServiceImpl();
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void play() {
        // 금액을 입력하세요.
        int money = readMoney();

        // 로또 구매 진행
        lottoBuyProcess(money);

        // 당첨 통계 출력
        printResult();
    }

    private int readMoney() {
        resultView.amountRequestPrintln();
        int money = inputView.readLine();
        resultView.println(String.valueOf(money));
        return money;
    }

    private void lottoBuyProcess(int money) {
        LottoTicketVouchersDto lottoTicketVouchersDto = lottoService.buyLotto(money);
        // 구입된 로또 번호 목록
        printVouchers(lottoTicketVouchersDto);
    }

    private void printVouchers(LottoTicketVouchersDto lottoTicketVouchersDto) {
        printBuyCount(lottoTicketVouchersDto.size());
        resultView.println(lottoTicketVouchersDto.toString());
    }

    private void printResult() {
        String lottoReport = lottoService.toLottoReport(readWinNumbers());
        resultView.println(lottoReport);
    }

    private int[] readWinNumbers() {
        resultView.winnerRequestPrintln();
        return inputView.readLineToArray();
    }

    private void printBuyCount(int size) {
        resultView.buyCutPrintln(size);
    }
}
