package lotto.controller.converter;

import lotto.controller.dto.MoneyDTO;
import lotto.domain.Money;

public class MoneyConverter {

    public static Money convert(MoneyDTO dto) {
        return Money.from(dto.getMoney());
    }
}
