package lotto.money;

import lotto.Purchasable;

public class CanNotDeductException extends RuntimeException {
    public CanNotDeductException(Money money, Purchasable purchasable) {
        super(String.format("구매가 불가능 합니다. (Money: %s / Purchasable: %s)", money, purchasable));
    }
}
