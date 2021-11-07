package study.lotto.controller;

import study.lotto.controller.dto.LottoOrderMoneyRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.model.LottoStore;
import study.lotto.model.Money;
import study.lotto.model.WinningStatistics;

public class LottoController {

    public static TicketLotteryBundleResponseDto orderTicketLotteryBundleByMoney(final LottoOrderMoneyRequestDto orderCountRequestDto) {
        final Money money = orderCountRequestDto.toEntity();
        return new TicketLotteryBundleResponseDto(LottoStore.orderTicketLotteryBundleByMoney(money));
    }

    public static WinningStatisticsResponseDto referee(final LottoWinningNumberRequestDto winningNumberRequestDto,
                                                       final TicketLotteryBundleResponseDto ticketLotteryBundleResponseDto) {
        final WinningStatistics winningStatistics = WinningStatistics.valueOf(ticketLotteryBundleResponseDto.toEntity(), winningNumberRequestDto.toEntity());
        return new WinningStatisticsResponseDto(winningStatistics);
    }
}
