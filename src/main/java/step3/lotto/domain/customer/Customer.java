package step3.lotto.domain.customer;

import java.util.ArrayList;
import java.util.List;
import step3.lotto.domain.customer.wrap.ManualAttemptsCount;
import step3.lotto.domain.customer.wrap.Price;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.domain.lotto.Lottos;
import step3.lotto.utils.LottoNumberUtils;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:03 오후
 */
public class Customer {

    public static final String INVALID_MANUAL_LOTTOS_SIZE_ERROR = "수동 횟수 만큼 수동 로또 번호를 입력하세요.";

    private Price price;
    private ManualAttemptsCount manualAttemptsCount;
    private Lottos lottos;

    public Customer(int price) {
        this.price = Price.of(price);
        this.lottos = publishLottos();
    }

    public Customer(Price price, ManualAttemptsCount manualAttemptsCount, Lottos manualLottos) {
        validateManualLottos(manualAttemptsCount, manualLottos);
        this.price = price;
        this.manualAttemptsCount = manualAttemptsCount;
        this.lottos = publishLottos();
        addManualLottos(manualLottos);
    }

    private void validateManualLottos(ManualAttemptsCount manualAttemptsCount, Lottos manualLottos) {
        if (manualAttemptsCount.getManualAttemptsCount() != manualLottos.getLottosSize()) {
            throw new IllegalArgumentException(INVALID_MANUAL_LOTTOS_SIZE_ERROR);
        }
    }

    public void addManualLottos(Lottos manualLottos) {
        lottos.addAll(manualLottos);
    }

    private Lottos publishLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getAutoAttemptsCount(); i++) {
            lottos.add(Lotto.of(LottoNumberUtils.generateLottoNumbers()));
        }
        return new Lottos(lottos);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public int getTotalAttemptsCount() {
        return price.calculateAttemptsCount();
    }

    public int getManualAttemptsCount() {
        return manualAttemptsCount.getManualAttemptsCount();
    }

    public int getAutoAttemptsCount() {
        return getTotalAttemptsCount() - getManualAttemptsCount();
    }

    public int getLottosSize() {
        return lottos.getLottosSize();
    }
}
