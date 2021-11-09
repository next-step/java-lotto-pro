package study.lotto.service;

import study.lotto.controller.dto.LottoOrderRequestDto;
import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.controller.dto.WinningStatisticsResponseDto;
import study.lotto.model.LottoStore;
import study.lotto.model.Money;
import study.lotto.model.Rank;
import study.lotto.model.TicketLotteryBundle;
import study.lotto.model.WinningLottery;
import study.lotto.model.WinningStatistics;
import study.lotto.model.exception.NotEnoughMoneyException;

import java.util.List;

public class LottoService {
    public static TicketLotteryBundleResponseDto orderTicketLotteryBundle(final LottoOrderRequestDto orderRequestDto) {
        final TicketLotteryBundle manualTicketLotteryBundle = orderRequestDto.getManualTicketLotteryBundle().toEntity();
        try {
            final Money money = orderRequestDto.getAutoOrderMoneyRequestDto().toEntity();
            final TicketLotteryBundle autoTicketLotteryBundle = LottoStore.orderTicketLotteryBundleByMoney(money);
            return new TicketLotteryBundleResponseDto(autoTicketLotteryBundle.merge(manualTicketLotteryBundle));
        } catch (final NotEnoughMoneyException exception) {
            return new TicketLotteryBundleResponseDto(manualTicketLotteryBundle);
        }
    }

    public static WinningStatisticsResponseDto fetchWinningStatistics(final LottoWinningNumberRequestDto winningNumberRequestDto, final TicketLotteryBundleResponseDto ticketLotteryBundleResponseDto) {
        final TicketLotteryBundle ticketLotteryBundle = ticketLotteryBundleResponseDto.toEntity();
        final WinningLottery winningLottery = winningNumberRequestDto.toEntity();
        final List<Rank> refereedRanks = winningLottery.match(ticketLotteryBundle);
        return new WinningStatisticsResponseDto(WinningStatistics.valueOf(refereedRanks));
    }
}
