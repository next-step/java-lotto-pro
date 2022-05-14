package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_TICKET_PRICE;
import static lotto.messages.ErrorMessages.MONEY_UNDER_PRICE_ERROR;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.LottoRandomNumberGenerateStrategy;
import lotto.domain.generator.NumberGenerateStrategy;

public class LottoVendingMachine {

    private final NumberGenerateStrategy strategy;

    public LottoVendingMachine() {
        this.strategy = new LottoRandomNumberGenerateStrategy();
    }

    public LottoTickets purchase(Money money) {
        validatePurchaseMoney(money);
        int quantity = money.divide(LOTTO_TICKET_PRICE);
        return generateLottoTickets(quantity);
    }

    private void validatePurchaseMoney(Money money) {
        if (money.isSmallerThan(LOTTO_TICKET_PRICE)) {
            throw new IllegalArgumentException(MONEY_UNDER_PRICE_ERROR);
        }
    }

    private LottoTickets generateLottoTickets(int quantity) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoNumbers.add(LottoNumbers.from(strategy));
        }
        return LottoTickets.from(lottoNumbers);
    }
}
