package study.lotto.domain.order;

import study.lotto.domain.Lotto;
import study.lotto.domain.Store;
import study.message.LottoExceptionCode;
import study.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final Quantity quantity;
    private int manualQuantity = NumberUtil.INIT_ZERO;
    private final List<Lotto> manualLottos = new ArrayList<>();

    public Order(String amount) {
        this.quantity = new Quantity(amount);
    }

    public void addManualQuantity(int manualQuantity) {
        this.manualQuantity = checkManualQuantity(manualQuantity);
    }

    private int checkManualQuantity(int manualQuantity) {
        if(quantity.isValidManualOrder(manualQuantity)) {
            return manualQuantity;
        }

        throw new IllegalArgumentException(LottoExceptionCode.FAILED_MANUAL_ORDER.getMessage());
    }

    public boolean canOrderManualLotto() {
        return manualLottos.size() < manualQuantity;
    }

    public void addManualLotto(String manualLotto) {
        manualLottos.add(Store.buyLottoManually(manualLotto));
    }

    public List<Lotto> orderManually() {
        return manualLottos;
    }

    public List<Lotto> orderAutomatically() {
        return Store.buyLottosAutomatically(quantity.getAutoQuantity(manualQuantity));
    }

}
