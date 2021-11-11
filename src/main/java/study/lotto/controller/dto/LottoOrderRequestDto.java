package study.lotto.controller.dto;

import study.lotto.model.Customer;

import java.util.List;
import java.util.Set;

public class LottoOrderRequestDto {

    private final List<Set<Integer>> manualTicketLotteryBundle;
    private final int money;

    public LottoOrderRequestDto(final List<Set<Integer>> manualTicketLotteryBundle, final int money) {
        this.money = money;
        this.manualTicketLotteryBundle = manualTicketLotteryBundle;
    }

    public Customer toEntity() {
        return Customer.valueOf(money, manualTicketLotteryBundle);
    }

    @Override
    public String toString() {
        return "LottoOrderRequestDto{" +
                "manualTicketLotteryBundle=" + manualTicketLotteryBundle +
                ", money=" + money +
                '}';
    }
}
