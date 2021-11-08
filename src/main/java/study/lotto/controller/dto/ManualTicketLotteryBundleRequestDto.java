package study.lotto.controller.dto;

import study.lotto.model.TicketLotteryBundle;
import study.lotto.model.TicketLotteryType;

import java.util.List;
import java.util.Set;

public class ManualTicketLotteryBundleRequestDto {
    private final List<Set<Integer>> manualTicketLotteryBundle;

    public ManualTicketLotteryBundleRequestDto(List<Set<Integer>> manualTicketLotteryBundle) {
        this.manualTicketLotteryBundle = manualTicketLotteryBundle;
    }

    public TicketLotteryBundle toEntity() {
        return TicketLotteryBundle.valueOf(manualTicketLotteryBundle, TicketLotteryType.MANUAL);
    }

}
