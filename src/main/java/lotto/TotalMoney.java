package lotto;

import java.util.Objects;

public class TotalMoney {
    private final int totalMoney;

    public TotalMoney(int totalMoney) {
        Validate.validateOnlyNumber(String.valueOf(totalMoney));
        this.totalMoney = totalMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TotalMoney that = (TotalMoney) o;
        return totalMoney == that.totalMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalMoney);
    }
}
