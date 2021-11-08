package lotto.domain;

import java.util.Objects;

//로또 발급 개수와 관련된 역할을 가진 클래스
public class LottoIssuanceCount {

    public static final int LOTTO_PRICE = 1000;
    private int issuanceCount;

    public LottoIssuanceCount(int issuanceCount) {
        this.issuanceCount = issuanceCount;
    }

    public static LottoIssuanceCount issuanceNumberCalculation(Money money) {
        int issuanceCount = money.getPurchaseAmount() / LOTTO_PRICE;
        return new LottoIssuanceCount(issuanceCount);
    }

    public int getIssuanceCount() {
        return issuanceCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoIssuanceCount that = (LottoIssuanceCount) o;
        return issuanceCount == that.issuanceCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuanceCount);
    }
}
