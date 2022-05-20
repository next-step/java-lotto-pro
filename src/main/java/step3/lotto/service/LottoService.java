package step3.lotto.service;

import step3.lotto.domain.customer.Customer;
import step3.lotto.domain.lotto.MatchStatistic;
import step3.lotto.domain.lotto.Winnings;

/**
 * @author : choi-ys
 * @date : 2022/05/17 3:27 오후
 */
public class LottoService {

    public MatchStatistic play(Customer customer, Winnings winnings) {
        return winnings.match(customer.getLottos());
    }
}
