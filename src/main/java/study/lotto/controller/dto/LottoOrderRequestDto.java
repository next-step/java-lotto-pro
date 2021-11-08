package study.lotto.controller.dto;

import java.util.List;
import java.util.Set;

public class LottoOrderRequestDto {
    private final ManualTicketLotteryBundleRequestDto manualTicketLotteryBundle;
    private final LottoOrderMoneyRequestDto autoOrderMoneyRequestDto;

    public LottoOrderRequestDto(final List<Set<Integer>> manualTicketLotteryBundle, final int autoOrderMoney) {
        this.autoOrderMoneyRequestDto = new LottoOrderMoneyRequestDto(autoOrderMoney);
        this.manualTicketLotteryBundle = new ManualTicketLotteryBundleRequestDto(manualTicketLotteryBundle);
    }

    public ManualTicketLotteryBundleRequestDto getManualTicketLotteryBundle() {
        return manualTicketLotteryBundle;
    }

    public LottoOrderMoneyRequestDto getAutoOrderMoneyRequestDto() {
        return autoOrderMoneyRequestDto;
    }
}
