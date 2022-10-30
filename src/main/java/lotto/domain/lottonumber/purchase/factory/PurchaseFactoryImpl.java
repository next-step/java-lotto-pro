package lotto.domain.lottonumber.purchase.factory;

import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.lottonumber.purchase.factory.validation.DefaultPurchaseValidator;
import lotto.domain.lottonumber.purchase.factory.validation.PurchaseValidator;

public class PurchaseFactoryImpl implements PurchaseFactory {

    private PurchaseValidator validator;
    private String purchase;

    public PurchaseFactoryImpl(String purchase) {
        this.validator = new DefaultPurchaseValidator();
        this.purchase = purchase;
    }

    @Override
    public Purchase createPurchase() {
        validator.validate(purchase);
        return new Purchase(purchase);
    }
}
