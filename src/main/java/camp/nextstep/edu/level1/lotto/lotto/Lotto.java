package camp.nextstep.edu.level1.lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final int LOTTO_PRICE = 1000;

    private Money money;
    private List<LottoNumbers> items = new ArrayList<>();

    public Lotto(int value) {
        checkValidLottoPurchaseMoney(value);

        this.money = new Money(value);
        int availablePurchaseCount = money.getAvailablePurchaseCount(LOTTO_PRICE);

        this.purchaseLotto(availablePurchaseCount);
    }

    private void checkValidLottoPurchaseMoney(int value) {
        if (value < LOTTO_PRICE) {
            String message = String.format("로또 구입시 최소 %d 원 이상이 있어야 합니다.", LOTTO_PRICE);
            throw new IllegalArgumentException(message);
        }
    }

    private void purchaseLotto(int count) {
        for (int i = 0; i < count; i++) {
            this.items.add(new LottoNumbers());
        }

        this.money.sub(count * LOTTO_PRICE);

        System.out.printf("%d개를 구입했습니다.%n", count);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.items.stream().map(LottoNumbers::toString).collect(Collectors.joining("\n"));
    }
}
