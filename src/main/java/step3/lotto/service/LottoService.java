package step3.lotto.service;

import step3.lotto.domain.customer.Customer;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.domain.lotto.Lottos;
import step3.lotto.domain.lotto.MatchStatistic;

/**
 * @author : choi-ys
 * @date : 2022/05/17 3:27 오후
 */
public class LottoService {

    public MatchStatistic play(Customer customer, Lotto lastWinningLotto) {
        Lottos lottos = customer.getLottos();
        return lottos.match(lastWinningLotto);
    }
}
