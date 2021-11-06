package study.lotto.controller.dto;

import study.lotto.model.LottoNumber;
import study.lotto.model.TicketLottery;
import study.lotto.model.TicketLotteryBundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TicketLotteryBundleResponseDto {

    private final List<TicketLotteryResponseDto> ticketLotteryResponseDtos = new ArrayList<>();

    public TicketLotteryBundleResponseDto(TicketLotteryBundle ticketLotteryBundle) {
        final List<TicketLottery> ticketLotteries = ticketLotteryBundle.getTicketLotteries();
        for (final TicketLottery ticketLottery : ticketLotteries) {
            ticketLotteryResponseDtos.add(new TicketLotteryResponseDto(ticketLottery));
        }
    }

    public List<TicketLotteryResponseDto> getTicketLotteryResponseDtos() {
        return Collections.unmodifiableList(ticketLotteryResponseDtos);
    }

    public TicketLotteryBundle toEntity() {
        final List<TicketLottery> ticketLotteries = new ArrayList<>();
        for (final TicketLotteryResponseDto ticketLotteryResponseDto : ticketLotteryResponseDtos) {
            final Set<LottoNumber> lottoNumberSet = ticketLotteryResponseDto.toEntity();
            ticketLotteries.add(TicketLottery.valueOf(lottoNumberSet));
        }
        return TicketLotteryBundle.valueOf(ticketLotteries);
    }
}
