package lotto.domain.lottonumber.purchase.role;

import static lotto.domain.lottonumber.purchase.Purchase.LOTTO_COST;

public class LottoNumberCountMaker implements PurchaseRole {

    @Override
    public int execute(String purchase) {
        return Integer.parseInt(purchase) / LOTTO_COST;
    }
}
