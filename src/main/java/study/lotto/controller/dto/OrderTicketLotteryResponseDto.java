package study.lotto.controller.dto;

import study.lotto.model.Customer;
import study.lotto.model.TicketLottery;
import study.lotto.model.TicketLotteryBundle;
import study.lotto.model.TicketLotteryType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class OrderTicketLotteryResponseDto {

    private final List<TicketLotteryResponseDto> ticketLotteryResponseDtos = new ArrayList<>();
    private final int manualTicketSize;
    private final int autoTicketSize;

    public OrderTicketLotteryResponseDto(Customer customer) {
        this.manualTicketSize = customer.getManualTicketSize();
        this.autoTicketSize = customer.getAutoTicketSize();
        addAll(customer.getTicketLotteries());
    }

    private void addAll(final List<TicketLottery> ticketLotteries) {
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
            final Set<Integer> lottoNumberSet = ticketLotteryResponseDto.getLottoNumbers();
            ticketLotteries.add(TicketLottery.valueOf(lottoNumberSet, TicketLotteryType.AUTO));
        }
        return TicketLotteryBundle.valueOf(ticketLotteries);
    }

    public int getManualTicketSize() {
        return manualTicketSize;
    }

    public int getAutoTicketSize() {
        return autoTicketSize;
    }
}
