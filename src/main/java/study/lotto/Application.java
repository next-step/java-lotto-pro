package study.lotto;

import study.lotto.controller.LottoController;
import study.lotto.controller.dto.LottoOrderMoneyRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.view.LottoOrderCountInputView;
import study.lotto.view.LottoOrderResultView;
import study.lotto.view.LottoWinningNumberInputView;
import study.lotto.view.LottoWinningStatisticsView;

public class Application {
    private static final LottoController controller; // 로또 게임 컨트롤러
    private static final LottoOrderCountInputView orderInputView; // 구매 입력 뷰
    private static final LottoWinningNumberInputView winningNumberInputView; // 당첨 번호 입력 뷰
    private static final LottoOrderResultView orderResultView; // 구매 내역 뷰
    private static final LottoWinningStatisticsView winningStatisticsView;// 당첨 통계 뷰

    static {
        controller = new LottoController();
        orderInputView = new LottoOrderCountInputView();
        orderResultView = new LottoOrderResultView();
        winningNumberInputView = new LottoWinningNumberInputView();
        winningStatisticsView = new LottoWinningStatisticsView();
    }

    public static void main(String[] args) {
        final TicketLotteryBundleResponseDto ticketLotteryBundle = orderTicketLotteryBundle();
        refereeTicketLottery(ticketLotteryBundle);
    }

    private static TicketLotteryBundleResponseDto orderTicketLotteryBundle() {
        final LottoOrderMoneyRequestDto money = orderInputView.submit();
        final TicketLotteryBundleResponseDto ticketLotteryBundle = controller.orderTicketLotteryBundleByMoney(money);
        orderResultView.resolve(ticketLotteryBundle);
        return ticketLotteryBundle;
    }

    private static void refereeTicketLottery(final TicketLotteryBundleResponseDto ticketLotteryBundle) {
        final LottoWinningNumberRequestDto lottoNumbers = winningNumberInputView.submit();
        final WinningStatisticsResponseDto winningStatistics = controller.referee(lottoNumbers, ticketLotteryBundle);
        winningStatisticsView.resolve(winningStatistics);
    }
}
