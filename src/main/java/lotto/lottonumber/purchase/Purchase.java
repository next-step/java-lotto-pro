package lotto.lottonumber.purchase;

import lotto.lottonumber.purchase.role.LottoNumberCountMaker;
import lotto.lottonumber.purchase.role.PurchaseRole;
import lotto.lottonumber.purchase.validation.DefaultPurchaseValidator;

public class Purchase {

    public static final int LOTTO_COST = 1000;
    private String purchase;
    private PurchaseRole role;

    public Purchase(String purchase) {
        new DefaultPurchaseValidator().validate(purchase);
        this.purchase = purchase;
        this.role = new LottoNumberCountMaker();
    }

    public int makeLottoNumberCount() {
        return role.execute(purchase);
    }
}
