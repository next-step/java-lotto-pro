package study.lotto;

import study.lotto.controller.LottoController;
import study.lotto.controller.dto.LottoOrderMoneyRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.view.LottoOrderMoneyInputView;
import study.lotto.view.LottoOrderResultView;
import study.lotto.view.LottoWinningNumberInputView;
import study.lotto.view.LottoWinningStatisticsView;

public class Application {

    public static void main(String[] args) {
        final TicketLotteryBundleResponseDto ticketLotteryBundle = orderTicketLotteryBundle();
        refereeTicketLottery(ticketLotteryBundle);
    }

    private static TicketLotteryBundleResponseDto orderTicketLotteryBundle() {
        final LottoOrderMoneyRequestDto money = LottoOrderMoneyInputView.submit();
        final TicketLotteryBundleResponseDto ticketLotteryBundle = LottoController.orderTicketLotteryBundleByMoney(money);
        LottoOrderResultView.resolve(ticketLotteryBundle);
        return ticketLotteryBundle;
    }

    private static void refereeTicketLottery(final TicketLotteryBundleResponseDto ticketLotteryBundle) {
        final LottoWinningNumberRequestDto winningLottoNumbers = LottoWinningNumberInputView.submit();
        final WinningStatisticsResponseDto winningStatistics = LottoController.referee(winningLottoNumbers, ticketLotteryBundle);
        LottoWinningStatisticsView.resolve(winningStatistics);
    }
}
