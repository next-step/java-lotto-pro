package study.lotto.controller;

import study.lotto.controller.dto.LottoOrderRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.service.LottoService;

public class LottoController {

    public static TicketLotteryBundleResponseDto orderTicketLotteryBundle(final LottoOrderRequestDto orderRequestDto) {
        return LottoService.orderTicketLotteryBundle(orderRequestDto);
    }

    public static WinningStatisticsResponseDto fetchWinningStatistics(final LottoWinningNumberRequestDto winningNumberRequestDto,
                                                                      final TicketLotteryBundleResponseDto ticketLotteryBundleResponseDto) {
        return LottoService.fetchWinningStatistics(winningNumberRequestDto, ticketLotteryBundleResponseDto);
    }
}
