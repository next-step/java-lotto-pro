package study.lotto.controller;

import study.lotto.controller.dto.LottoOrderCountRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.model.LottoStore;
import study.lotto.model.WinningStatistics;

public class LottoGameController {
    public TicketLotteryBundleResponseDto generateTicketLottery(final LottoOrderCountRequestDto orderCountRequestDto) {
        final int orderCount = orderCountRequestDto.getOrderCount();
        return new TicketLotteryBundleResponseDto(LottoStore.purchase(orderCount));
    }

    public WinningStatistics referee(final LottoWinningNumberRequestDto winningNumberRequestDto,
                                     final TicketLotteryBundleResponseDto ticketLotteryBundleResponseDto) {
        return WinningStatistics.valueOf(ticketLotteryBundleResponseDto.toEntity(), winningNumberRequestDto.toEntity());
    }
}
