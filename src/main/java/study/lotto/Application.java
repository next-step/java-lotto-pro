package study.lotto;

import study.lotto.controller.LottoGameController;
import study.lotto.controller.dto.LottoOrderCountRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.model.WinningStatistics;
import study.lotto.view.LottoOrderCountInputView;
import study.lotto.view.LottoOrderResultView;
import study.lotto.view.LottoWinningNumberInputView;
import study.lotto.view.LottoWinningStatisticsView;

public class Application {
    private static final LottoGameController controller; // 로또 게임 컨트롤러
    private static final LottoOrderCountInputView orderInputView; // 구매 입력 뷰
    private static final LottoWinningNumberInputView winningNumberInputView; // 당첨 번호 입력 뷰
    private static final LottoOrderResultView orderResultView; // 구매 내역 뷰
    private static final LottoWinningStatisticsView winningStatisticsView;// 당첨 통계 뷰

    static {
        controller = new LottoGameController();
        orderInputView = new LottoOrderCountInputView();
        orderResultView = new LottoOrderResultView();
        winningNumberInputView = new LottoWinningNumberInputView();
        winningStatisticsView = new LottoWinningStatisticsView();
    }

    public static void main(String[] args) {
        final TicketLotteryBundleResponseDto ticketLotteryBundle = orderTicketLottery();
        refereeTicketLottery(ticketLotteryBundle);
    }

    private static TicketLotteryBundleResponseDto orderTicketLottery() {
        final LottoOrderCountRequestDto money = orderInputView.submit();
        final TicketLotteryBundleResponseDto ticketLotteryBundle = controller.generateTicketLottery(money);
        orderResultView.resolve(ticketLotteryBundle);
        return ticketLotteryBundle;
    }

    private static void refereeTicketLottery(final TicketLotteryBundleResponseDto ticketLotteryBundle) {
        final LottoWinningNumberRequestDto lottoNumbers = winningNumberInputView.submit();
        final WinningStatistics winningStatistics = controller.referee(lottoNumbers, ticketLotteryBundle);
        winningStatisticsView.resolve(winningStatistics);
    }
}
