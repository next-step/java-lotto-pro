package study.lotto.model;

import java.util.HashSet;
import java.util.Set;

public class OrderManualTicketLottery {
    private final Set<LottoNumber> orderManualLottoNumbers = new HashSet<>();

    private OrderManualTicketLottery(final Set<Integer> numbers) {
        for (final Integer number : numbers) {
            this.orderManualLottoNumbers.add(LottoNumber.valueOf(number));
        }
    }

    public static OrderManualTicketLottery valueOf(Set<Integer> numbers) {
        return new OrderManualTicketLottery(numbers);
    }

    public TicketLottery parseTicketLottery(final TicketLotteryType type) {
        final Set<Integer> lottoNumbers = new HashSet<>();
        for (final LottoNumber lottoNumber : orderManualLottoNumbers) {
            lottoNumbers.add(lottoNumber.getValue());
        }
        return TicketLottery.valueOf(lottoNumbers, type);
    }
}
