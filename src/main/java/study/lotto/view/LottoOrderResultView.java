package study.lotto.view;

import study.lotto.controller.dto.TicketLotteryBundleResponseDto;
import study.lotto.controller.dto.TicketLotteryResponseDto;

import java.util.List;

public class LottoOrderResultView {

    private static final String ORDER_GUIDE_MESSAGE = "%d개를 구매했습니다.\n";

    private LottoOrderResultView() {
    }

    public static void resolve(final TicketLotteryBundleResponseDto ticketLotteryBundle) {
        final List<TicketLotteryResponseDto> ticketLotteryResponseDtos = ticketLotteryBundle.getTicketLotteryResponseDtos();
        printOrderCount(ticketLotteryResponseDtos.size());
        printTicketLotteryBundle(ticketLotteryResponseDtos);
    }

    private static void printOrderCount(final int orderCount) {
        System.out.printf(ORDER_GUIDE_MESSAGE, orderCount);
    }

    private static void printTicketLotteryBundle(final List<TicketLotteryResponseDto> ticketLotteryResponseDtos) {
        System.out.println();
        for (final TicketLotteryResponseDto ticketLotteryResponseDto : ticketLotteryResponseDtos) {
            System.out.println(ticketLotteryResponseDto.getLottoNumbers());
        }
        System.out.println();
    }

}
