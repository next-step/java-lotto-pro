package study.lotto.service;

import study.lotto.controller.dto.LottoOrderRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.OrderTicketLotteryResponseDto;
import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.model.Customer;
import study.lotto.model.LottoStore;
import study.lotto.model.Rank;
import study.lotto.model.TicketLotteryBundle;
import study.lotto.model.WinningLottery;
import study.lotto.model.WinningStatistics;

import java.util.List;

public class LottoService {

    private final LottoStore lottoStore;

    public LottoService() {
        this.lottoStore = LottoStore.getInstance();
    }

    public OrderTicketLotteryResponseDto orderTicketLotteryBundle(final LottoOrderRequestDto orderRequestDto) {
        final Customer customer = orderRequestDto.toEntity();
        lottoStore.sellTo(customer);
        return new OrderTicketLotteryResponseDto(customer);
    }

    public WinningStatisticsResponseDto fetchWinningStatistics(final LottoWinningNumberRequestDto winningNumberRequestDto, final OrderTicketLotteryResponseDto orderTicketLotteryResponseDto) {
        final TicketLotteryBundle ticketLotteryBundle = orderTicketLotteryResponseDto.toEntity();
        final WinningLottery winningLottery = winningNumberRequestDto.toEntity();
        final List<Rank> refereedRanks = winningLottery.match(ticketLotteryBundle);
        return new WinningStatisticsResponseDto(WinningStatistics.valueOf(refereedRanks));
    }
}
