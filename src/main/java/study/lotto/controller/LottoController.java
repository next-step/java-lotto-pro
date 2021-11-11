package study.lotto.controller;

import study.lotto.controller.dto.LottoOrderRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.OrderTicketLotteryResponseDto;
import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public OrderTicketLotteryResponseDto orderTicketLotteryBundle(final LottoOrderRequestDto orderRequestDto) {
        return lottoService.orderTicketLotteryBundle(orderRequestDto);
    }

    public WinningStatisticsResponseDto fetchWinningStatistics(final LottoWinningNumberRequestDto winningNumberRequestDto,
                                                               final OrderTicketLotteryResponseDto orderTicketLotteryResponseDto) {
        return lottoService.fetchWinningStatistics(winningNumberRequestDto, orderTicketLotteryResponseDto);
    }
}
