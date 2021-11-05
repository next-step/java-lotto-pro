package lotto;

import java.util.Objects;

//로또 발급 개수와 관련된 역할을 가진 클래스
public class LottoIssuanceCount {

    private int issuanceCount;

    public LottoIssuanceCount(int issuanceCount) {
        this.issuanceCount = issuanceCount;
    }

    public static LottoIssuanceCount issuanceNumberCalculation(int purchaseAmount) {
        purchaseAmountOneThousandWonUnitValid(purchaseAmount);
        int issuanceCount = purchaseAmount / LottoProperty.LOTTO_PRICE;
        return new LottoIssuanceCount(issuanceCount);
    }

    private static void purchaseAmountOneThousandWonUnitValid(int purchaseAmount) {
        if (purchaseAmount % LottoProperty.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_ONE_THOUSAND_WON.getMessage());
        }
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
