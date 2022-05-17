package step3.lotto.domain.customer;

import java.util.ArrayList;
import java.util.List;
import step3.lotto.domain.customer.wrap.Price;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.domain.lotto.Lottos;
import step3.lotto.utils.LottoNumberUtils;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:03 오후
 */
public class Customer {

    private Price price;
    private Lottos lottos;

    public Customer(int price) {
        this.price = Price.of(price);
        this.lottos = publishLottos();
    }

    private Lottos publishLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getTryCount(); i++) {
            lottos.add(Lotto.of(LottoNumberUtils.generateLottoNumbers()));
        }
        return new Lottos(lottos);
    }

    public int getTryCount() {
        return this.price.calculateTryCount();
    }

    public int getLottosSize() {
        return lottos.size();
    }
}
