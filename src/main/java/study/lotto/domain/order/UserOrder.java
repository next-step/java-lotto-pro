package study.lotto.domain.order;

import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;
import study.message.LottoExceptionCode;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserOrder {
    private UserPurchase userPurchase;
    private ManualOrder manualOrder;
    private AutoOrder autoOrder;

    public UserOrder(String purchaseAmount) {
        this.userPurchase = new UserPurchase(purchaseAmount);
    }

    public int checkManualQuantity(int manualQuantity) {
        if(userPurchase.isValidManualOrder(manualQuantity)) {
            return manualQuantity;
        }
        throw new IllegalArgumentException(LottoExceptionCode.FAILED_MANUAL_ORDER.getMessage());
    }

    public void prepareOrder(int manualQuantity) {
        this.manualOrder = new ManualOrder(manualQuantity);
        this.autoOrder = new AutoOrder(userPurchase.getAutoQuantity(manualQuantity));
    }

    public void createManualOrder(String lotto) {
        manualOrder.create(lotto);
    }

    public Lottos order() {
        List<Lotto> manualLottos = manualOrder.order(userPurchase);
        List<Lotto> autoLottos = autoOrder.order(userPurchase);

        return combineLottos(manualLottos, autoLottos);
    }

    private Lottos combineLottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        return new Lottos(Stream.of(manualLottos, autoLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return manualOrder.toString() + "," + autoOrder.toString();
    }
}
