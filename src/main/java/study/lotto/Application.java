package study.lotto;

import study.lotto.controller.LottoController;
import study.lotto.controller.dto.LottoOrderMoneyRequestDto;
import study.lotto.controller.dto.LottoOrderRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.OrderTicketLotteryResponseDto;
import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.view.input.LottoManualOrderInputView;
import study.lotto.view.input.LottoOrderMoneyInputView;
import study.lotto.view.input.LottoWinningNumberInputView;
import study.lotto.view.out.LottoOrderResultView;
import study.lotto.view.out.LottoWinningStatisticsResultView;

public class Application {

    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        fetchWinningStatistics(orderTicketLotteryBundle());
    }

    private static OrderTicketLotteryResponseDto orderTicketLotteryBundle() {
        final LottoOrderRequestDto orderRequest = lottoOrderSubmit();
        final OrderTicketLotteryResponseDto ticketLotteryBundle = lottoController.orderTicketLotteryBundle(orderRequest);
        LottoOrderResultView.resolve(ticketLotteryBundle);
        return ticketLotteryBundle;
    }

    private static void fetchWinningStatistics(OrderTicketLotteryResponseDto ticketLotteryBundle) {
        final LottoWinningNumberRequestDto winningLottoNumbers = LottoWinningNumberInputView.submit();
        final WinningStatisticsResponseDto winningStatistics = lottoController.fetchWinningStatistics(winningLottoNumbers, ticketLotteryBundle);
        LottoWinningStatisticsResultView.resolve(winningStatistics);
    }

    private static LottoOrderRequestDto lottoOrderSubmit() {
        final LottoOrderMoneyRequestDto money = LottoOrderMoneyInputView.submit();
        return LottoManualOrderInputView.submit(money);
    }
}
