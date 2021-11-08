package study.lotto.view.out;

import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.controller.dto.TicketLotteryResponseDto;

import java.util.List;

public class LottoOrderResultView {

    private static final String ORDER_GUIDE_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    private LottoOrderResultView() {
    }

    public static void resolve(final TicketLotteryBundleResponseDto ticketLotteryBundle) {
        final List<TicketLotteryResponseDto> ticketLotteryResponseDtos = ticketLotteryBundle.getTicketLotteryResponseDtos();
        printOrderCount(getAutoOrderCount(ticketLotteryResponseDtos), getManualOrderCount(ticketLotteryResponseDtos));
        printTicketLotteryBundle(ticketLotteryResponseDtos);
    }

    private static int getManualOrderCount(final List<TicketLotteryResponseDto> ticketLotteryResponseDtos) {
        return (int) ticketLotteryResponseDtos.stream()
                .filter(ticketLotteryResponseDto -> ticketLotteryResponseDto.getType().isManualTicket())
                .count();
    }

    private static int getAutoOrderCount(final List<TicketLotteryResponseDto> ticketLotteryResponseDtos) {
        return (int) ticketLotteryResponseDtos.stream()
                .filter(ticketLotteryResponseDto -> ticketLotteryResponseDto.getType().isAutoTicket())
                .count();
    }

    private static void printOrderCount(final int manualOrderCount, final int autoOrderCount) {
        System.out.printf(ORDER_GUIDE_MESSAGE, manualOrderCount, autoOrderCount);
    }

    private static void printTicketLotteryBundle(final List<TicketLotteryResponseDto> ticketLotteryResponseDtos) {
        System.out.println();
        for (final TicketLotteryResponseDto ticketLotteryResponseDto : ticketLotteryResponseDtos) {
            System.out.println(ticketLotteryResponseDto.getLottoNumbers());
        }
        System.out.println();
    }

}
