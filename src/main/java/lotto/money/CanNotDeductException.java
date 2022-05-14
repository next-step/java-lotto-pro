package lotto.money;

public class CanNotDeductException extends RuntimeException {
    public CanNotDeductException(Money money, Money otherMoney) {
        super(String.format("차감이 불가능 합니다. (money: %s / otherMoney: %s)", money, otherMoney));
    }
}
